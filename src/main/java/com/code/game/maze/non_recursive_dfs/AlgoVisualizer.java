package com.code.game.maze.non_recursive_dfs;

import java.awt.*;
import java.util.Stack;

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

        Stack<Position> stack = new Stack<>();
        Position entrance = new Position(data.getEntranceX(), data.getEntranceY());
        stack.push(entrance);
        data.visited[entrance.getX()][entrance.getY()] = true;

        boolean isSolved = false;

        while (!stack.isEmpty()) {
            Position curPos = stack.pop();
            setData(curPos.getX(), curPos.getY(), true);

            if (curPos.getX() == data.getExitX() && curPos.getY() == data.getExitY()) {
                isSolved = true;
                findPath(curPos);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int newX = curPos.getX() + d[i][0];
                int newY = curPos.getY() + d[i][1];

                if (data.inArea(newX, newY) && !data.visited[newX][newY] && data.getMaze(newX, newY) == MazeData.ROAD) {
                    stack.push(new Position(newX, newY, curPos));
                    data.visited[newX][newY] = true;
                }
            }
        }
        setData(-1, -1, false);
    }

    private void findPath(Position des) {
        Position cur = des;
        while (cur != null) {
            data.result[cur.getX()][cur.getY()] = true;
            cur = cur.getPrev();
        }
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
