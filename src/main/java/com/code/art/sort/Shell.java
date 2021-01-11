package com.code.art.sort;

/**
 * 描述: 希尔排序
 *
 * @author zhourao
 * @create 2021-01-06 12:08 下午
 */
public class Shell {

    public static <T> void sort(Comparable<T>[] a) {
        //将a[]按升序排列
        int N = a.length;
        int h = 1;

        while (h < N / 3 + 1) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                //将a[j]插入到a[j-h]、a[j-2h]、a[j-3h]...之中
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
                    exch(a, j, j - h);
            }
            h = h / 3;
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
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        show(a);
        sort(a);
        assert isSorted(a);
    }
}