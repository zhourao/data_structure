package com.code.art.sort;

/**
 * 描述: 优先队列
 * 使用二叉堆实现
 *
 * @author zhourao
 * @create 2021-01-09 5:12 下午
 */
public class MaxPQ<E extends Comparable<E>> {

    private E[] pq;

    private int N = 0;//存储在pq[1,...N]中，pq[0]没使用

    public MaxPQ(int maxN) {
        pq = (E[]) new Object[maxN + 1];
    }

    public void enqueue(E e) {
        pq[++N] = e; //在数组末尾添加元素
        swim(N); //上浮操作
    }

    public E dequeue() {
        if (N == pq.length - 1)
            resize(2 * pq.length - 1);
        E max = pq[1]; //从根节点得到最大元素
        exch(pq, 1, N--); //将其和最后一个结点交换
        pq[N + 1] = null; // 防止对象游离
        sink(1); //恢复堆的有序性
        if (N == (pq.length - 1) / 4 && (pq.length - 1) / 2 != 0)
            resize(pq.length / 2 + 1);
        return max;
    }

    public int getSize() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 上浮操作
     *
     * @param k 添加元素
     */
    private void swim(int k) {
        while (k > 1 && less(pq[k / 2], pq[k])) {
            exch(pq, k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(pq[j], pq[j + 1])) j++;
            if (!less(k, j)) break;
            exch(pq, k, j);
            k = j;
        }
    }


    private static <T> void exch(Comparable<T>[] a, int i, int j) {
        Comparable<T> t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static <T> boolean less(Comparable<T> v, Comparable<T> w) {
        return v.compareTo((T) w) < 0;
    }

    private void resize(int newMaxN) {
        E[] newData = (E[]) new Object[newMaxN + 1];
        for (int i = 0; i < N; i++)
            newData[i] = pq[i];
        pq = newData;
    }
}