package com.code.art.leetcode;

import java.util.*;

/**
 * 描述:数组总和 https://leetcode-cn.com/problems/combination-sum/
 *
 * @author zhourao
 * @create 2021-08-16 10:42 下午
 */
public class Code0039 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, combine, ans, 0);
        return ans;
    }

    private void backtrack(int[] candidates, int remains, List<Integer> combine, List<List<Integer>> ans, int start) {
        if (remains == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }

        if (remains < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remains) {
                break;
            }
            combine.add(candidates[i]);
            backtrack(candidates, remains - candidates[i], combine, ans, i);
            combine.remove(combine.size() - 1);
        }
    }
}
