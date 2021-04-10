package com.code.art.offer;

/**
 * 描述: 剪绳子 II
 * https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/
 *
 * @author zhourao
 * @create 2021-04-10 9:53 下午
 */
public class Offer14_II {

    /**
     * 【题目】剪绳子 II
     * 【题目说明】
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     *
     * 输入: 2
     * 输出: 1
     * 解释: 2 = 1 + 1, 1 × 1 = 1
     *
     * 输入: 10
     * 输出: 36
     * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
     */
    public static int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int b = n % 3, p = 1000000007;
        long rem = 1, x = 3;
        for (int a = n / 3 - 1; a > 0; a /= 2) {
            if (a % 2 == 1) rem = (rem * x) % p;
            x = (x * x) % p;
        }
        if (b == 0) return (int) (rem * 3 % p);
        if (b == 1) return (int) (rem * 4 % p);
        return (int) (rem * 6 % p);
    }

    public static void main(String[] args) {
        System.out.println(cuttingRope(2));
        System.out.println(cuttingRope(3));
        System.out.println(cuttingRope(4));
        System.out.println(cuttingRope(5));
        System.out.println(cuttingRope(6));
        System.out.println(cuttingRope(7));
        System.out.println(cuttingRope(8));
        System.out.println(cuttingRope(9));
        System.out.println(cuttingRope(10));
    }
}