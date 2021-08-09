package com.code.art.leetcode;

/**
 * 描述: 最长回文子串
 *
 * @author zhourao
 * @create 2021-07-06 11:42 上午
 */
public class Code0005 {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s == null ? "" : s;
        boolean[][] dp = new boolean[s.length()][s.length()];

        int start = 0;
        int max = 1;
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                max = 2;
            }
        }

        for (int l = 3; l <= s.length(); l++) {
            for (int i = 0; l + i <= s.length(); i++) {
                int j = l + i - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    start = i;
                    max = l;
                }
            }
        }
        return s.substring(start, start + max);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ccc"));
        System.out.println(longestPalindrome("abaaba"));
    }
}
