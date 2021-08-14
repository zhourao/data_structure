package com.code.art.leetcode;

/**
 * 描述:长度最小的子数组 https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 *
 * @author zhourao
 * @create 2021-08-14 10:54 上午
 */
public class Code0209 {

    public static int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int left = 0, add = 0;
        for (int right = 0; right < nums.length; right++) {
            add += nums[right];
            while (add >= target) {
                ans = Math.min(ans, right - left + 1);
                add -= nums[left++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, nums));
    }
}
