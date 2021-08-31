package com.code.art.leetcode;

import java.util.Arrays;

/**
 * 描述:最长递增子序列  https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *
 * @author zhourao
 * @create 2021-08-18 10:44 上午
 */
public class Code0300 {

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++)
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            maxLen = Math.max(dp[i], maxLen);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
    }
}
