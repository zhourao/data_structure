package com.code.art.offer;

import java.util.Arrays;

/**
 * 描述: 股票的最大利润
 * https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 *
 * @author zhourao
 * @create 2021-04-16 10:01 上午
 */
public class Offer63 {

    /**
     * 【题目】股票的最大利润
     * 【题目说明】
     * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
     * 【示例1】
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
     * 【示例2】
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     */
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for(int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }


    public static void main(String[] args) {

    }
}