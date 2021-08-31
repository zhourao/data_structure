package com.code.art.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述: 两数之和 https://leetcode-cn.com/problems/two-sum/
 *
 * @author zhourao
 * @create 2021-08-30 10:25 上午
 */
public class Code0001 {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (maps.containsKey(target - nums[i]))
                return new int[]{maps.get(target - nums[i]), i};
            maps.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        System.out.println(twoSum(nums, 9)[0] + " " + twoSum(nums, 9)[1]);
        System.out.println(twoSum(nums, 18)[0] + " " + twoSum(nums, 18)[1]);
        System.out.println(twoSum(nums, 13)[0] + " " + twoSum(nums, 13)[1]);
    }
}
