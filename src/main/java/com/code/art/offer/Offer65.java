package com.code.art.offer;

/**
 * 描述:不用加减乘除做加法
 * https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
 *
 * @author zhourao
 * @create 2021-04-16 10:01 上午
 */
public class Offer65 {

    /**
     * 【题目】不用加减乘除做加法
     * 【题目说明】
     * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
     * 【示例1】
     * 输入: a = 1, b = 1
     * 输出: 2
     */
    public int add(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }


    public static void main(String[] args) {

    }
}