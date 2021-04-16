package com.code.art.offer;

/**
 * 描述: 数值的整数次方
 * https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 *
 * @author zhourao
 * @create 2021-04-10 9:53 下午
 */
public class Offer16 {

    /**
     * 【题目】数值的整数次方
     * 【题目说明】
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
     * 【示例】
     * 输入：x = 2.00000, n = 10
     * 输出：1024.00000
     * 输入：x = 2.10000, n = 3
     * 输出：9.26100
     * 输入：x = 2.00000, n = -2
     * 输出：0.25000
     * 解释：2-2 = 1/22 = 1/4 = 0.25
     */
    public static double myPow(double x, int n) {
        if (n == 0) return 1;
        long b = n;
        if (n < 0) {
            b *= -1;
            x = 1 / x;
        }
        double res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2d, 10));
        System.out.println(myPow(1d, 31));
    }
}