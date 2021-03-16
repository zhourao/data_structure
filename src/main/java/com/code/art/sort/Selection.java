package com.code.art.sort;

/**
 * 描述: 选择排序
 *
 * @author zhourao
 * @create 2021-01-06 10:22 上午
 */
public class Selection {

    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            //遍历找到最小的元素
            for (int j = i + 1; j < a.length; j++)
                if (less(a[j], a[min])) min = j;
            //对元素进行交换
            exch(a, i, min);
        }
    }

    /**
     * @param v   参数v
     * @param w   参数w
     * @param <T> 泛型
     * @return T/F=v是否比w小
     */
    private static <T> boolean less(Comparable<T> v, Comparable<T> w) {
        return v.compareTo((T) w) < 0;
    }

    /**
     * @param a   数组
     * @param i   索引位置
     * @param j   索引位置
     * @param <T> 泛型
     */
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