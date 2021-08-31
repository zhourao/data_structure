package com.code.art.leetcode;

/**
 * 描述: 整数拆分 https://leetcode-cn.com/problems/integer-break/
 *
 * @author zhourao
 * @create 2021-08-25 3:50 下午
 */
public class Code0343 {

    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = i - 1;
            for (int j = 2; j <= i/2+1; j++) {
                int max = Math.max(j, dp[j]);
                dp[i] = Math.max(dp[i], max * (i - j));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(2));
        System.out.println(integerBreak(3));
        System.out.println(integerBreak(4));
        System.out.println(integerBreak(5));
        System.out.println(integerBreak(7));
        System.out.println(integerBreak(10));
    }
}
