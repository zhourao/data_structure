package com.code.art.leetcode;

/**
 * 描述:跳跃游戏 II  https://leetcode-cn.com/problems/jump-game-ii/
 *
 * @author zhourao
 * @create 2021-08-20 4:23 下午
 */
public class Code0045 {

    public static int jump(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }


    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
    }
}
