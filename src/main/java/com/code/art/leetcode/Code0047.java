package com.code.art.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 描述: 全排列 II https://leetcode-cn.com/problems/permutations-ii/
 *
 * @author zhourao
 * @create 2021-08-16 10:21 下午
 */
public class Code0047 {

    boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, perm, ans, 0);
        return ans;
    }

    private void backtrack(int[] nums, List<Integer> perm, List<List<Integer>> ans, int idx) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(perm));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(nums, perm, ans, idx + 1);
            vis[i] = false;
            perm.remove(idx);
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};

        Code0047 c = new Code0047();
        List<List<Integer>> list = c.permuteUnique(nums);

        System.out.println(list);
    }
}
