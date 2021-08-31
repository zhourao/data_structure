package com.code.art.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 描述: 零钱兑换  https://leetcode-cn.com/problems/coin-change/
 *
 * @author zhourao
 * @create 2021-08-25 3:29 下午
 */
public class Code0322 {

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
            for (int coin : coins)
                if (coin <= i && dp[i - coin] < amount)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2, 3}, 1));
        System.out.println(coinChange(new int[]{2, 4}, 11));
        System.out.println(coinChange(new int[]{1, 2, 3}, 8));
        System.out.println(coinChange(new int[]{1, 2, 3}, 9));
        System.out.println(coinChange(new int[]{1, 2, 3}, 10));
    }
}
