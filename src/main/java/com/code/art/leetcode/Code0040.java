package com.code.art.leetcode;

import java.util.*;

/**
 * 描述:数组总和II https://leetcode-cn.com/problems/combination-sum-ii/
 *
 * @author zhourao
 * @create 2021-08-19 8:00 上午
 */
public class Code0040 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, combine, ans, 0);
        return ans;
    }

    private void backtrack(int[] candidates, int remains, List<Integer> combine, List<List<Integer>> ans, int start) {
        if (remains <= 0 || start >= candidates.length) {
            if (remains == 0) {
                ans.add(new ArrayList<>(combine));
            }
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remains) {
                break;
            }
            if (i > start && candidates[i - 1] == candidates[i]) {
                continue;
            }
            combine.add(candidates[i]);
            backtrack(candidates, remains - candidates[i], combine, ans, i + 1);
            combine.remove(combine.size() - 1);
        }
    }
}
