package com.code.art.leetcode;

import java.util.Arrays;

/**
 * 描述: 不同路径  https://leetcode-cn.com/problems/unique-paths/
 *
 * @author zhourao
 * @create 2021-08-20 10:09 下午
 */
public class Code0062 {


    public int uniquePaths(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] += cur[j - 1];
            }
        }
        return cur[n - 1];
    }
}
