package com.code.art.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * 描述:圆圈中最后剩下的数字
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 *
 * @author zhourao
 * @create 2021-04-16 10:01 上午
 */
public class Offer62 {

    /**
     * 【题目】圆圈中最后剩下的数字
     * 【题目说明】
     * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
     * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
     * 【示例1】
     * 输入: n = 5, m = 3
     * 输出: 3
     * 【示例2】
     * 输入: n = 10, m = 17
     * 输出: 2
     */
    public int lastRemaining(int n, int m) {
        int x = 0;
        for (int i = 2; i <= n; i++)
            x = (x + m) % i;
        return x;
    }


    public static void main(String[] args) {

    }
}