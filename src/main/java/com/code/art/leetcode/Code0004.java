package com.code.art.leetcode;

/**
 * 描述:寻找两个正序数组的中位数 https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 *
 * @author zhourao
 * @create 2021-08-30 11:11 上午
 */
public class Code0004 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int len = m + n;
        int left = -1, right = -1, aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            right = aStart < m && (bStart >= n || nums1[aStart] < nums2[bStart]) ? nums1[aStart++] : nums2[bStart++];
        }
        return (len & 1) == 0 ? (left + right) / 2.0 : right;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
