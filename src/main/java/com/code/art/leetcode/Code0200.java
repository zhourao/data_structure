package com.code.art.leetcode;

/**
 * 描述:岛屿数量 https://leetcode-cn.com/problems/number-of-islands/
 *
 * @author zhourao
 * @create 2021-08-14 11:10 上午
 */
public class Code0200 {

    public int numIslands_dfs(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int num_islands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    num_islands++;
                    dfs(grid, i, j);
                }
            }
        }
        return num_islands;
    }

    private static void dfs(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }
}
