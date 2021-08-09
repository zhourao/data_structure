package com.code.art.leetcode;

/**
 * 描述:寻找最值 https://leetcode-cn.com/problems/find-peak-element/
 *
 * @author zhourao
 * @create 2021-08-08 12:00 上午
 */
public class Code0162 {

    public static int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return findPeakElement(nums, 0, nums.length - 1);
    }

    private static int findPeakElement(int[] nums, int l, int r) {
        if (l >= r) {
            return l;
        }

        int mid = l + (r - l) / 2;
        if (nums[mid] > nums[mid + 1]) {
            return findPeakElement(nums, l, mid);
        }
        return findPeakElement(nums, mid + 1, r);
    }


    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 1};
        System.out.println(findPeakElement(a));
    }
}