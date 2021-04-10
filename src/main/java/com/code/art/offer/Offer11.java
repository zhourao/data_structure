package com.code.art.offer;


/**
 * 描述: 旋转数组的最小数字
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 *
 * @author zhourao
 * @create 2021-04-10 9:28 上午
 */
public class Offer11 {

    /**
     * 【题目】旋转数组的最小数字
     * 【题目说明】
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
     *
     * 【示例】
     * 输入：[3,4,5,1,2]
     * 输出：1
     *
     * 输入：[2,2,2,0,1]
     * 输出：0
     */
    public static int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = i + (j - i) / 2;
            if (numbers[m] > numbers[j]) i = m + 1;
            else if (numbers[m] < numbers[j]) j = m;
            else j--;
        }
        return numbers[i];
    }

    public static void main(String[] args) {
        System.out.println(minArray(new int[]{3, 4, 5, 6, 7, 8, 9, 1, 2}));
    }
}