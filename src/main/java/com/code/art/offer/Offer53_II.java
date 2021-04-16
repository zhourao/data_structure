package com.code.art.offer;

/**
 * 描述:0～n-1中缺失的数字
 * https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
 *
 * @author zhourao
 * @create 2021-04-16 10:01 上午
 */
public class Offer53_II {

    /**
     * 【题目】0～n-1中缺失的数字
     * 【题目说明】
     * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
     * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
     * 【示例1】
     * 输入: [0,1,3]
     * 输出: 2
     * 【示例】
     * 输入: [0,1,2,3,4,5,6,7,9]
     * 输出: 8
     */
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }

    public static void main(String[] args) {

    }
}