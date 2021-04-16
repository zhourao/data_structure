package com.code.art.offer;

/**
 * 描述: 打印从1到最大的n位数
 * https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 *
 * @author zhourao
 * @create 2021-04-10 9:53 下午
 */
public class Offer17 {

    /**
     * 【题目】打印从1到最大的n位数
     * 【题目说明】
     * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
     * 【示例】
     * 输入: n = 1
     * 输出: [1,2,3,4,5,6,7,8,9]
     */
    public static int[] printNumbers(int n) {
        int[] arr = new int[(int) (Math.pow(10,n) - 1)];
        for (int i = 0; i < arr.length; i++)
            arr[i] = i + 1;
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(printNumbers(3));
    }
}