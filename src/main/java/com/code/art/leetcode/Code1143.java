package com.code.art.leetcode;

import java.util.Arrays;

/**
 * 描述: 最长公共子序列 https://leetcode-cn.com/problems/longest-common-subsequence/
 *
 * @author zhourao
 * @create 2021-08-22 9:03 下午
 */
public class Code1143 {

    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                dp[i + 1][j + 1] = text1.charAt(i) == text2.charAt(j) ? dp[i][j] + 1 : Math.max(dp[i + 1][j], dp[i][j + 1]);
        return dp[m][n];
    }


    public static int longestCommonSubsequence2(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[] dp = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int upLeft = dp[0];
            for (int j = 0; j < n; j++) {
                int tmp = dp[j + 1];
                dp[j + 1] = text1.charAt(i) == text2.charAt(j) ? upLeft + 1 : Math.max(dp[j], dp[j + 1]);
                upLeft = tmp;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
        System.out.println(longestCommonSubsequence2("abcde", "ace"));
        System.out.println(longestCommonSubsequence("bd", "ace"));
        System.out.println(longestCommonSubsequence2("bd", "ace"));
        System.out.println(longestCommonSubsequence2("abcba", "abcbcba"));
    }
}
