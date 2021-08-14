package com.code.art.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:所有可能的路径 https://leetcode-cn.com/problems/all-paths-from-source-to-target/
 *
 * @author zhourao
 * @create 2021-08-14 10:00 下午
 */
public class Code797 {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return solve(graph, 0);
    }

    public List<List<Integer>> solve(int[][] graph, int node) {
        int N = graph.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (node == N - 1) {
            List<Integer> path = new ArrayList<>();
            path.add(N - 1);
            ans.add(path);
            return ans;
        }

        for (int nei : graph[node]) {
            for (List<Integer> path : solve(graph, nei)) {
                path.add(0, node);
                ans.add(path);
            }
        }
        return ans;
    }
}
