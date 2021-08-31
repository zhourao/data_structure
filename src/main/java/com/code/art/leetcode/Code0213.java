package com.code.art.leetcode;

import java.util.Arrays;

/**
 * 描述: 打家劫舍 II  https://leetcode-cn.com/problems/house-robber-ii/
 *
 * @author zhourao
 * @create 2021-08-20 2:37 下午
 */
public class Code0213 {

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private int myRob(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for (int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }
}
