package com.code.art.sort;

/**
 * 描述: 插入排序
 *
 * @author zhourao
 * @create 2021-01-06 10:57 上午
 */
public class Insertion {

    public static void simpleSort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            //将a[j]插入到a[j-1]、a[j-2]...a[0]之中
            for (int j = i; j >= 1 && less(a[j], a[j - 1]); j--)
                exch(a, j, j - 1);
        }
    }

    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            //①保存需待插入的数据值、设置需插入的数据位置
            Comparable insertV = a[i];
            int j = i;
            //②将大于insertVal的值向右移动
            while (j >= 1 && less(insertV, a[j - 1])) {
                a[j] = a[j - 1];
                j--;
            }
            //③将insertVal插入对应位置
            a[j] = insertV;
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
        sort(a);
        show(a);
        assert isSorted(a);
    }
}