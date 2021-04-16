package com.code.art.offer;

/**
 * 描述:数组中数字出现的次数 II
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
 *
 * @author zhourao
 * @create 2021-04-16 10:01 上午
 */
public class Offer56_II {

    /**
     * 【题目】数组中数字出现的次数 II
     * 【题目说明】
     * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
     * 【示例1】
     * 输入：nums = [3,4,3,3]
     * 输出：4
     * 【示例2】
     * 输入：nums = [9,1,7,9,7,9,7]
     * 输出：1
     */
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }


    public static void main(String[] args) {

    }
}