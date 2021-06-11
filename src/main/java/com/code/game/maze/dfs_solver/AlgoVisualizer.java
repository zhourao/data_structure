package com.code.game.maze.dfs_solver;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

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

    public AlgoVisualizer(String mazeFile) {
        //初始化数据
        // 初始化数据
        data = new MazeData(mazeFile);
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
        setData(-1, -1, false);

        if (!go(data.getEntranceX(), data.getEntranceY()))
            System.out.println("The maze has NO solution!");

        setData(-1, -1, false);

    }

    private boolean go(int x, int y) {

        if (!data.inArea(x, y))
            throw new IllegalArgumentException("x,y are out of index in go function!");

        data.visited[x][y] = true;
        setData(x, y, true);

        if (x == data.getExitX() && y == data.getExitY())
            return true;

        for (int i = 0; i < 4; i++) {
            int newX = x + d[i][0];
            int newY = y + d[i][1];
            if (data.inArea(newX, newY) &&
                    data.getMaze(newX, newY) == MazeData.ROAD &&
                    !data.visited[newX][newY])
                if (go(newX, newY))
                    return true;
        }

        // 回溯
        setData(x, y, false);
        
        return false;
    }


    private void setData(int x, int y, boolean isPath) {
        if (data.inArea(x, y))
            data.path[x][y] = isPath;

        frame.render(data);
        AlgoVisHelper.pause(DELAY);
    }

    public static void main(String[] args) {

        AlgoVisualizer visualizer = new AlgoVisualizer("src/main/resources/maze_101_101.txt");
    }
}
