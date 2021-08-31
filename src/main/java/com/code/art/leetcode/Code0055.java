package com.code.art.leetcode;

/**
 * 描述: 跳跃游戏  https://leetcode-cn.com/problems/jump-game/
 *
 * @author zhourao
 * @create 2021-08-20 4:08 下午
 */
public class Code0055 {


    public static boolean canJump(int[] nums) {
        int rightMost = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost, i + nums[i]);
                if (rightMost >= nums.length - 1)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
