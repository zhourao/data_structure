package com.code.art.sort;

/**
 * 描述:冒泡排序
 *
 * @author zhourao
 * @create 2021-03-12 11:40 上午
 */
public class BubbleSort {

    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            //设置冒泡数量i（初始为0）
            //按冒泡范围j∈[0,a.length()-1-i)进行遍历
            for (int j = 0; j < a.length - 1 - i; j++)
                //冒泡操作：相邻元素j（初始值0）和j+1进行比较
                // 如a[j]>a[j+1]则交换位置
                if (less(a[j + 1], a[j]))
                    exch(a, j, j + 1);
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
        sort(a);
        show(a);
        assert isSorted(a);
    }
}