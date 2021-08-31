package com.code.art.leetcode;

/**
 * 描述: 单词搜索 https://leetcode-cn.com/problems/word-search/
 *
 * @author zhourao
 * @create 2021-08-20 11:18 上午
 */
public class Code0079 {

    int h, w;
    boolean[][] visited;
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        h = board.length;
        w = board[0].length;
        visited = new boolean[h][w];

        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                if (check(board, i, j, word, 0))
                    return true;
        return false;
    }

    public boolean check(char[][] board, int i, int j, String s, int k) {

        if (board[i][j] != s.charAt(k)) {
            return false;
        } else if (k == s.length() - 1) {
            return true;
        }

        visited[i][j] = true;
        boolean result = false;
        for (int[] dir : directions) {
            int newX = i + dir[0], newY = j + dir[1];
            if (isAvailable(newX, newY) && check(board, newX, newY, s, k + 1)) {
                result = true;
                break;
            }
        }
        visited[i][j] = false;
        return result;
    }

    private boolean isAvailable(int newX, int newY) {
        return newX >= 0 && newX < h && newY >= 0 && newY < w && !visited[newX][newY];
    }
}
