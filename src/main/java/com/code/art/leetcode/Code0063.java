package com.code.art.leetcode;

/**
 * 描述: 不同路径II  https://leetcode-cn.com/problems/unique-paths-ii/
 *
 * @author zhourao
 * @create 2021-08-20 10:09 下午
 */
public class Code0063 {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid[0].length;

        int[] dp = new int[n];
        dp[0] = 1 - obstacleGrid[0][0];
        for (int[] ints : obstacleGrid)
            for (int j = 0; j < n; ++j)
                dp[j] += ints[j] == 1 ? -dp[j] : (j >= 1 ? dp[j - 1] : 0);
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
