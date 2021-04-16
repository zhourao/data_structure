package com.code.art.offer;

import java.util.Arrays;

/**
 * 描述: 丑数
 * https://leetcode-cn.com/problems/chou-shu-lcof/
 *
 * @author zhourao
 * @create 2021-04-10 9:53 下午
 */
public class Offer49 {

    /**
     * 【题目】丑数
     * 【题目说明】
     * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
     * 【示例】
     * 输入: n = 10
     * 输出: 12
     * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
     */
    public static int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (n2 == dp[i]) a++;
            if (n3 == dp[i]) b++;
            if (n5 == dp[i]) c++;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
}