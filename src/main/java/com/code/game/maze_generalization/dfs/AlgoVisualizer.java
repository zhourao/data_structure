package com.code.game.maze_generalization.dfs;

import java.awt.*;

/**
 * 算法应用视图
 *
 * @author zhourao
 * @date 2021/5/22
 */
public class AlgoVisualizer {

    /**
     * 绘画间隔 毫秒
     */
    private static int DELAY = 5;

    private static int blockSide = 8;

    /**
     * 数据
     */
    private MazeData data;

    /**
     * 视图
     */
    private AlgoFrame frame;
    private static final int d[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public AlgoVisualizer(int N, int M) {

        // 初始化数据
        data = new MazeData(N, M);
        int sceneHeight = data.N() * blockSide;
        int sceneWidth = data.M() * blockSide;

        //初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);
            new Thread(() -> {
                run();
            }).start();
        });
    }

    /**
     * 动画逻辑
     */
    private void run() {
        setData(-1, -1);
        go(data.getEntranceX(), data.getEntranceY());
        setData(-1, -1);
    }

    private void go(int x, int y) {
        if (!data.inArea(x, y))
            throw new IllegalArgumentException("x,y are out of index in go function!");

        data.visited[x][y] = true;
        setData(x, y);

        for (int i = 0; i < 4; i++) {
            int newX = x + d[i][0] * 2;
            int newY = y + d[i][1] * 2;
            if (data.inArea(newX, newY) && !data.visited[newX][newY]) {
                setData(x + d[i][0], y + d[i][1]);
                go(newX, newY);
            }
        }
        setData(x, y);
    }


    private void setData(int x, int y) {
        if (data.inArea(x, y))
            data.maze[x][y] = MazeData.ROAD;

        frame.render(data);
        AlgoVisHelper.pause(DELAY);
    }

    public static void main(String[] args) {
        int N = 101;
        int M = 101;
        AlgoVisualizer vis = new AlgoVisualizer(N, M);
    }
}
