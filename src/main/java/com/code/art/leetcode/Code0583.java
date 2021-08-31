package com.code.art.leetcode;

/**
 * 描述: 两个字符串的删除操作 https://leetcode-cn.com/problems/delete-operation-for-two-strings/
 *
 * @author zhourao
 * @create 2021-08-22 9:23 下午
 */
public class Code0583 {


    public static int minDistance(String word1, String word2) {
        return word1.length() + word2.length() - 2 * lcs(word1, word2);
    }

    public static int lcs(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                dp[i + 1][j + 1] = word1.charAt(i) == word2.charAt(j) ? dp[i][j] + 1 : Math.max(dp[i + 1][j], dp[i][j + 1]);
        return dp[m][n];
    }


    public static void main(String[] args) {
        System.out.println(minDistance("sea", "eat"));
    }
}
