package com.code.art.leetcode;

import java.util.Random;

/**
 * 描述: 数组中的第K个最大元素  https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 *
 * @author zhourao
 * @create 2021-08-25 3:15 下午
 */
public class Code0215 {

    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] a, int l, int r, int index) {
        int q = randomPartition(a, l, r);
        return q == index ? a[q] : q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
    }

    private int randomPartition(int[] a, int l, int r) {
        int ri = random.nextInt(r - l + 1) + l;
        swap(a, ri, r);

        int x = a[r], i = l - 1;
        for (int j = l; j < r; ++j)
            if (a[j] <= x)
                swap(a, ++i, j);

        swap(a, i + 1, r);
        return i + 1;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
