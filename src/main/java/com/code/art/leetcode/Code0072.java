package com.code.art.leetcode;

/**
 * 描述:编辑距离 https://leetcode-cn.com/problems/edit-distance/
 *
 * @author zhourao
 * @create 2021-08-25 2:30 下午
 */
public class Code0072 {


    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        // 有一个字符串为空串
        if (n * m == 0) return n + m;
        // DP数组
        int[][] D = new int[n + 1][m + 1];
        // 边界状态初始化
        for (int i = 0; i < n + 1; i++) D[i][0] = i;
        for (int j = 0; j < m + 1; j++) D[0][j] = j;

        // 计算所有DP值
        for (int i = 1; i < n + 1; i++)
            for (int j = 1; j < m + 1; j++)
                D[i][j] = Math.min(D[i - 1][j] + 1, Math.min(D[i][j - 1] + 1,
                        word1.charAt(i - 1) == word2.charAt(j - 1) ? D[i - 1][j - 1] : D[i - 1][j - 1] + 1));

        return D[n][m];
    }
}
