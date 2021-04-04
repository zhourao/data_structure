package com.code.art.base.sort10;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 描述: 桶排序
 *
 * @author zhourao
 * @create 2021-03-25 10:10 上午
 */
public class Bucket {

    public static int[] sort(int[] a) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            max = Math.max(max, a[i]);
            min = Math.min(min, a[i]);
        }

        //创建桶
        int bucketNum = (max - min) / a.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<ArrayList<Integer>>(bucketNum);
        for (int i = 0; i < bucketNum; i++)
            bucketArr.add(new ArrayList<Integer>());

        //将每个元素都放入桶中
        for (int i = 0; i < a.length; i++) {
            int num = (a[i] - min) / a.length;
            bucketArr.get(num).add(a[i]);
        }

        bucketArr.forEach(Collections::sort);

        int i = 0;
        for (ArrayList<Integer> bucket : bucketArr)
            for (Integer e : bucket) {
                a[i] = e;
                i++;
            }
        return a;
    }

    private static boolean less(int v, int w) {
        return v - w < 0;
    }

    private static <T> void show(int[] a) {
        //在单行中打印数组
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    public static boolean isSorted(int[] a) {
        //测试数组元素是否有序
        for (int i = 0; i < a.length; i++) {
            if (less(a[i], a[i - 1]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = {6, 5, 4, 3, 10, 20, 1};
        show(a);
        sort(a);
        show(a);
        assert isSorted(a);
    }
}