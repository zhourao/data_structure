package com.code.art.base.sort10;

/**
 * 描述: 快速排序
 *
 * @author zhourao
 * @create 2021-01-07 11:05 上午
 */
public class Quick {

    public static void sort(Comparable[] a) {
        //StdRandom.shuffle(a); //消除对输入的依赖
        sort(a, 0, a.length - 1);
        //sort3way(a, 0, a.length - 1);
    }

    //将数组a[lo..li]排序
    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        // 元素过少的时候使用插入排序优化
        // if (hi <= lo + 16) { Insertion.sort(a);return; }
        int i = lo, j = hi; //左右扫描指针

        while (i < j) {//扫描左右，检查是否结束并交换元素
            while (i < j && !less(a[j], a[lo])) j--;
            while (i < j && !less(a[lo], a[i])) i++;
            exch(a, i, j);
        }
        exch(a, lo, i); //将v = a[j]放入正确的位置

        sort(a, lo, i - 1);  //将左半部分a[lo..i]排序
        sort(a, i + 1, hi); //将右半部分a[i+1..hi]排序
    }

    private static void sort3way(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        // 元素过少的时候使用插入排序优化
        // if (hi <= lo + 16) { Insertion.sort(a);return; }
        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, i, gt--);
            else i++;
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    private static <T> boolean less(Comparable<T> v, Comparable<T> w) {
        return v.compareTo((T) w) < 0;
    }

    private static <T> void exch(Comparable<T>[] a, int i, int j) {
        Comparable<T> t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static <T> void show(Comparable<T>[] a) {
        //在单行中打印数组
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    public static <T> boolean isSorted(Comparable<T>[] a) {
        //测试数组元素是否有序
        for (int i = 0; i < a.length; i++) {
            if (less(a[i], a[i - 1]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] a = {"M", "E", "R", "G", "E", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        show(a);
        sort(a);
        show(a);
        assert isSorted(a);
    }
}