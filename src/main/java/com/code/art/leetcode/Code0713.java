package com.code.art.leetcode;

/**
 * 描述: 乘积小于K的子数组 https://leetcode-cn.com/problems/subarray-product-less-than-k/
 *
 * @author zhourao
 * @create 2021-08-14 10:36 上午
 */
public class Code0713 {

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        // 必须<，＝不包括在里面
        if (k <= 1) return 0;
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];

            while (prod >= k) {
                prod /= nums[left++];
            }

            ans += right - left + 1;
            // [2,3,4,5]  25
            // 2 [2] ans += 1
            // 2 3 [3] + [2,3] ans+= 1 - 0 + 1 = 2
            // 2 3 4 [4] + [3,4] + [2,3,4] ans + = 2 - 0 + 1 = 3
            // 4 5 [5] + [4,5] ans + = 5 - 4 + 1 = 2
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 5};
        System.out.println(numSubarrayProductLessThanK(nums, 25));
    }
}
