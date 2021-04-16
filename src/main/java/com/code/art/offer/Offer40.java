package com.code.art.offer;

import java.util.Arrays;

/**
 * 描述: 最小的k个数
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 *
 * @author zhourao
 * @create 2021-04-10 9:53 下午
 */
public class Offer40 {

    /**
     * 【题目】最小的k个数
     * 【题目说明】
     * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     * 【示例1】
     * 输入：arr = [3,2,1], k = 2
     * 输出：[1,2] 或者 [2,1]
     * 【示例2】
     * 输入：arr = [0,1,2,1], k = 1
     * 输出：[0]
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1);
        return Arrays.copyOf(arr, k);
    }

    private void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;
        // 哨兵划分操作（以 arr[l] 作为基准数）
        int i = lo, j = hi;
        while (i < j) {
            while (i < j && arr[j] >= arr[lo]) j--;
            while (i < j && arr[i] <= arr[lo]) i++;
            exch(arr, i, j);
        }
        exch(arr, i, lo);
        // 递归左（右）子数组执行哨兵划分
        quickSort(arr, lo, i - 1);
        quickSort(arr, i + 1, hi);
    }

    private void exch(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
    }
}