package com.code.art.leetcode;

/**
 * 描述:寻找旋转排序数组中的最小值 https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * @author zhourao
 * @create 2021-08-08 12:00 上午
 */
public class Code0153 {

    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MAX_VALUE;
        }
        return findMin(nums, 0, nums.length - 1);
    }

    private static int findMin(int[] nums, int l, int r) {
        if (nums[l] <= nums[r]) {
            return nums[l];
        }
        int mid = l + (r - l) / 2;
        return Math.min(findMin(nums, l, mid), findMin(nums, mid + 1, r));
    }


    public static void main(String[] args) {
        int[] a = {5, 7, 8, 10, 0, 1, 2, 3, 4};
        System.out.println(findMin(a));
    }
}