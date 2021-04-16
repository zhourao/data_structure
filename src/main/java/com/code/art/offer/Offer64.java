package com.code.art.offer;

/**
 * 描述: 求1+2+…+n
 * https://leetcode-cn.com/problems/qiu-12n-lcof/
 *
 * @author zhourao
 * @create 2021-04-10 9:53 下午
 */
public class Offer64 {

    /**
     * 【题目】求1+2+…+n
     * 【题目说明】
     * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     * 【示例1】
     * 输入: n = 3
     * 输出: 6
     * 【示例2】
     * 输入: n = 9
     * 输出: 45
     */
    public static int sumNums(int n) {
        boolean x = n > 0 && (n = n + sumNums(n - 1)) > 0;
        return n;
    }

    public static void main(String[] args) {
        System.out.println(sumNums(10));
    }
}