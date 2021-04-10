package com.code.art.offer;


/**
 * 描述: 青蛙跳台阶问题
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 *
 * @author zhourao
 * @create 2021-04-10 9:28 上午
 */
public class Offer10_II {

    /**
     * 【题目】青蛙跳台阶问题
     * 【题目说明】
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
     *
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     *
     * 【示例】
     * 输入：n = 2
     * 输出：2
     *
     * 输入：n = 7
     * 输出：21
     *
     * 输入：n = 0
     * 输出：1
     */
    public static int numWays(int n) {
        int a = 1, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(numWays(0));
        System.out.println(numWays(1));
        System.out.println(numWays(2));
        System.out.println(numWays(7));
    }
}