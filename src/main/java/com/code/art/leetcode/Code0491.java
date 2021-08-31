package com.code.art.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述: 递增子序列 https://leetcode-cn.com/problems/increasing-subsequences/
 *
 * @author zhourao
 * @create 2021-08-18 10:13 上午
 */
public class Code0491 {


    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(0, Integer.MIN_VALUE, nums);
        return ans;
    }


    public void dfs(int cur, int last, int[] nums) {
        if (cur == nums.length) {
            if (temp.size() >= 2) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        // 添加当前元素
        if (nums[cur] >= last) {
            temp.add(nums[cur]);
            dfs(cur + 1, nums[cur], nums);
            temp.remove(temp.size() - 1);
        }

        // 如果元素不重复，则直接进行下个重申
        if (nums[cur] != last) {
            dfs(cur + 1, last, nums);
        }
    }

    public static void main(String[] args) {

    }
}
