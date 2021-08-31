package com.code.art.leetcode;

/**
 * 描述: 等差数列划分 https://leetcode-cn.com/problems/arithmetic-slices/
 *
 * @author zhourao
 * @create 2021-08-20 11:07 下午
 */
public class Code0413 {

    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int t = 0, res = 0;
        for (int i = 2; i < nums.length; i++) {
            t += nums[i - 2] - nums[i - 1] == nums[i - 1] - nums[i] ? 1 : -t;
            res += t;
        }
        return res;
    }
}