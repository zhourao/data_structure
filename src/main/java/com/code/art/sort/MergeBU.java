package com.code.art.sort;

/**
 * 描述: 自底向上的归并排序
 * 自底向上
 *
 * @author zhourao
 * @create 2021-01-07 10:35 上午
 */
public class MergeBU {

    //归并所需的辅助数组
    private static Comparable[] aux;

    public static <T> void sort(Comparable<T>[] a) {
        //进行lgN次两两递归
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) //sz子数组大小
            for (int lo = 0; lo < N - sz; lo += sz + sz) //lo:子数组索引
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
    }

    //将a[lo..mid]和a[mid+1..hi]归并
    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        //j将a[lo..hi]复制到aux[lo..hi]
        for (int k = lo; k <= hi; k++) aux[k] = a[k];
        //归并回到a[lo..hi]
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
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