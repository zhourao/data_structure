package com.code.art.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * 描述: 数组中重复的数字
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 *
 * @author zhourao
 * @create 2021-04-10 9:28 上午
 */
public class Offer03 {

    /**
     * 【题目】找出数组中重复的数字。
     * 【题目说明】
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字重复了，
     * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     *
     * 【示例】
     * 输入： [2, 3, 1, 0, 2, 5, 3]
     * 输出：2 或 3
     */
    public static int findRepeatNumber(int[] nums) {
        if (nums == null) return -1;
        Set<Integer> it = new HashSet<>();
        for (int num : nums) {
            if (it.contains(num)) return num;
            it.add(num);
        }
        return -1;
    }

    // 重要条件：在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
    // 即：只有[0,1,2,...,n-1]的数组才不会有重复的数字
    public static int findRepeatNumber2(int[] nums) {
        if (nums == null) return -1;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) return nums[i];
                int tmp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber2(nums));
    }
}