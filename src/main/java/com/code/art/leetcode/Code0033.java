package com.code.art.leetcode;

/**
 * 描述: 题目33：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 *
 * @author zhourao
 * @create 2021-08-07 2:17 下午
 */
public class Code0033 {

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {5, 7, 8, 10, 1, 2, 3};
        System.out.println(search(a, 0));
    }
}