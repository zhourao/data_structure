package com.code.art.sort;

/**
 * 描述: 优先队列
 * 使用二叉堆实现
 *
 * @author zhourao
 * @create 2021-01-09 5:12 下午
 */
public class IndexMaxPQ<Key extends Comparable<Key>> {

    private Key[] data;  //基于堆的完全二叉树
    private int[] indexes; //最大索引堆中的索引，indexes[x] = i 表示索引i在x的位置
    private int[] reverse; //最大索引堆中的反向索引，reverse[i] = x 表示索引i在x的位置

    private int count;
    private int capacity; //存储在pq[1,...N]中，pq[0]没使用

    public IndexMaxPQ(int capacity) {
        data = (Key[]) new Object[capacity + 1];
        indexes = new int[capacity + 1];
        reverse = new int[capacity + 1];
        for (int i = 0; i < capacity; i++)
            reverse[i] = 0;
        count = 0;
        this.capacity = capacity;
    }

    public void insert(int i, Key v) {
        assert count + 1 <= capacity;
        assert i + 1 >= 1 && i + 1 <= capacity;

        //在插入一个新元素前，还需要保证索引i所在的位置是没有元素的
        assert !contain(i);

        i += 1;//位置0不存储元素
        data[i] = v;
        indexes[count + 1] = i;
        reverse[i] = count + 1;
        count++;

        swim(count); //上浮操作
    }

    public Key delMax() {
        assert count > 0;

        Key max = data[indexes[1]];
        swapIndexes(1, count);
        reverse[indexes[count]] = 0;
        count--;
        sink(1);
        return max;
    }


    // 将最大索引堆中索引为i的元素修改为newItem
    public void change(int i, Key newVal) {
        assert contain(i);

        i += 1;
        data[i] = newVal;
        swim(reverse[i]);
        sink(reverse[i]);
    }

    /**
     * 上浮操作
     *
     * @param k 添加元素
     */
    private void swim(int k) {
        while (k > 1 && less(data[k / 2], data[k])) {
            swapIndexes(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= count) {
            int j = 2 * k;
            if (j < count && less(data[indexes[j]], data[indexes[j + 1]])) j++;
            if (!less(data[indexes[k]], data[indexes[j]])) break;
            k = j;
        }
    }

    // 看索引i所在的位置是否存在元素
    boolean contain(int i) {
        assert i + 1 >= 1 && i + 1 <= capacity;
        return reverse[i + 1] != 0;
    }

    // 交换索引堆中的索引i和j
    // 由于有了反向索引reverse数组，
    // indexes数组发生改变以后， 相应的就需要维护reverse数组
    private void swapIndexes(int i, int j) {
        int t = indexes[i];
        indexes[i] = indexes[j];
        indexes[j] = t;

        reverse[indexes[i]] = i;
        reverse[indexes[j]] = j;
    }

    private static <T> boolean less(Comparable<T> v, Comparable<T> w) {
        return v.compareTo((T) w) < 0;
    }
}