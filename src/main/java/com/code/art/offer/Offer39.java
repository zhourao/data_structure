package com.code.art.offer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述: 数组中出现次数超过一半的数字
 * https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 *
 * @author zhourao
 * @create 2021-04-15 2:44 下午
 */
public class Offer39 {

    /**
     * 【题目】数组中出现次数超过一半的数字
     * 【题目说明】
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * 【示例】
     * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
     * 输出: 2
     */
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0, count = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        // 验证 x 是否为众数
        for(int num : nums)
            if(num == x) count++;
        return count > nums.length / 2 ? x : 0; // 当无众数时返回 0
    }

    public static void main(String[] args) {

    }
}