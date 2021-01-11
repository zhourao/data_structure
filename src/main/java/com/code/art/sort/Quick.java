package com.code.art.sort;
/**
 * 描述: 快速排序
 *
 * @author zhourao
 * @create 2021-01-07 11:05 上午
 */
public class Quick {

    //归并所需的辅助数组
    private static Comparable[] aux;

    public static <T> void sort(Comparable<T>[] a) {
        //StdRandom.shuffle(a); //消除对输入的依赖
        sort(a, 0, a.length - 1);
    }

    //将数组切分为a[lo..i-1],a[i],a[i+1..hi]
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1; //左右扫描指针
        Comparable v = a[lo];
        while (true) {//扫描左右，检查是否结束并交换元素
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j); //将v = a[j]放入正确的位置
        return j; //a[lo..j-1] <= a[j] <= a[j+1..hi]达成
    }

    //将数组a[lo..li]排序
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);  //将左半部分a[lo..j-1]排序
        sort(a, j, hi); //将右半部分a[j..hi]排序
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