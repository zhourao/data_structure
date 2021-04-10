package com.code.art.offer;

import com.code.art.structure.queue.LinkedListQueue;
import com.code.art.structure.queue.Queue;

/**
 * 描述: 机器人的运动范围
 *
 * @author zhourao
 * @create 2021-04-10 9:53 下午
 */
public class Offer13 {

    /**
     * 【题目】机器人的运动范围
     * 【题目说明】
     * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
     * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
     * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
     *
     * 输入：m = 2, n = 3, k = 1
     * 输出：3
     *
     * 输入：m = 3, n = 1, k = 0
     * 输出：1
     */
    public int movingCount_DFS(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.visited = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }

    int m, n, k;
    boolean[][] visited;

    int dfs(int i, int j, int si, int sj) {
        if (i >= m || j >= n || k < si + sj || visited[i][j]) return 0;
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj)
                + dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
    }

    public int movingCount_BFS(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        Queue<int[]> queue = new LinkedListQueue<>();
        queue.enqueue(new int[]{0, 0, 0, 0});
        while (queue.getSize() > 0) {
            int[] x = queue.dequeue();
            int i = x[0], j = x[1], si = x[2], sj = x[3];
            if (i >= m || j >= n || k < si + sj || visited[i][j]) continue;
            visited[i][j] = true;
            res++;
            queue.enqueue(new int[]{i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj});
            queue.enqueue(new int[]{i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8});
        }
        return res;
    }


    public static void main(String[] args) {

    }
}