package com.code.art.offer;

/**
 * 描述: 剪绳子
 * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 *
 * @author zhourao
 * @create 2021-04-10 9:53 下午
 */
public class Offer14_I {

    /**
     * 【题目】剪绳子 II
     * 【题目说明】
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
     * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     *
     * 输入: 2
     * 输出: 1
     * 解释: 2 = 1 + 1, 1 × 1 = 1
     *
     * 输入: 10
     * 输出: 36
     * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
     */
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int[] maxArr = new int[n + 1];
        for (int i = 1; i < n + 1; i++)
            maxArr[i] = i <= 3 ? i : (Math.max(maxArr[2] * maxArr[i - 2], maxArr[3] * maxArr[i - 3]));

        return maxArr[n] % 1000000007;
    }



    public static void main(String[] args) {
        Offer14_I o = new Offer14_I();
        System.out.println(o.cuttingRope(2));
        System.out.println(o.cuttingRope(3));
        System.out.println(o.cuttingRope(4));
        System.out.println(o.cuttingRope(5));
        System.out.println(o.cuttingRope(6));
        System.out.println(o.cuttingRope(7));
        System.out.println(o.cuttingRope(8));
        System.out.println(o.cuttingRope(9));
        System.out.println(o.cuttingRope(10));
    }
}