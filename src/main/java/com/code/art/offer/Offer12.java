package com.code.art.offer;


/**
 * 描述: 矩阵中的路径
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 *
 * @author zhourao
 * @create 2021-04-10 9:28 上午
 */
public class Offer12 {

    /**
     * 【题目】矩阵中的路径
     * 【题目说明】
     * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
     *
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     * 【示例】
     * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     * 输出：true
     *
     * 输入：board = [["a","b"],["c","d"]], word = "abcd"
     * 输出：false
     */
    public static boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (dfs(board, words, i, j, 0)) return true;
        return false;
    }

    private static boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        //System.out.println("i=>" + i + ",j=>" + j + ",k=>" + k);
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0
                || board[i][j] != words[k])
            return false;
        //System.out.println(words[k]);
        if (k == words.length - 1) return true;
        board[i][j] = '\0';
        boolean res = dfs(board, words, i - 1, j, k + 1) || dfs(board, words, i + 1, j, k + 1)
                || dfs(board, words, i, j - 1, k + 1) || dfs(board, words, i, j + 1, k + 1);
        board[i][j] = words[k];
        return res;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";

        System.out.println(exist(board, word));
    }
}