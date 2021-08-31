package com.code.art.leetcode;

import java.util.Arrays;

/**
 * 描述: 最长递增子序列 https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *
 * @author zhourao
 * @create 2021-08-21 8:42 上午
 */
public class Code0673 {

    public static int findNumberOfLIS(int[] nums) {
        int N = nums.length;
        if (N <= 1) return N;
        int[] dp = new int[N];
        int[] counts = new int[N];
        Arrays.fill(counts, 1);

        for (int j = 0; j < N; ++j) {
            for (int i = 0; i < j; ++i)
                if (nums[i] < nums[j]) {
                    if (dp[i] >= dp[j]) {
                        dp[j] = dp[i] + 1;
                        counts[j] = counts[i];
                    } else if (dp[i] + 1 == dp[j]) {
                        counts[j] += counts[i];
                    }
                }
        }

        int longest = 0, ans = 0;
        for (int length : dp) {
            longest = Math.max(longest, length);
        }
        for (int i = 0; i < N; ++i) {
            if (dp[i] == longest) {
                ans += counts[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));
    }
}
