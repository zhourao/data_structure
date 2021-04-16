package com.code.art.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述: 调整数组顺序使奇数位于偶数前面
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 *
 * @author zhourao
 * @create 2021-04-12 9:53 下午
 */
public class Offer21 {

    /**
     * 【题目】调整数组顺序使奇数位于偶数前面
     * 【题目说明】
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
     * 【示例】
     * 输入：nums = [1,2,3,4]
     * 输出：[1,3,2,4]
     * 注：[3,1,2,4] 也是正确的答案之一。
     */
    public static int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1, tmp;
        while (i < j) {
            while (i < j && nums[j] % 2 == 0) j--;
            while (i < j && nums[i] % 2 != 0) i++;
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        exchange(nums);
        System.out.println(nums);
    }
}