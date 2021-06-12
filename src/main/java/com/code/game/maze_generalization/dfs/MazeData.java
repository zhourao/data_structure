package com.code.game.maze_generalization.dfs;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * 描述: 迷宫数据
 *
 * @author zhourao
 * @create 2021-06-10 4:42 下午
 */
public class MazeData {


    public static final char ROAD = ' ';
    public static final char WALL = '#';

    private int entranceX, entranceY;
    private int exitX, exitY;

    private int N, M;
    public char[][] maze;
    public boolean[][] path;
    public boolean[][] visited;

    public MazeData(int N, int M) {

        if (N % 2 == 0 || M % 2 == 0)
            throw new IllegalArgumentException("Our Maze Generalization Algorihtm requires the width and height of the maze are odd numbers");

        this.N = N;
        this.M = M;

        maze = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i % 2 == 1 && j % 2 == 1) {
                    maze[i][j] = ROAD;
                } else {
                    maze[i][j] = WALL;
                }
                visited[i][j] = false;
            }
        }


        entranceX = 1;
        entranceY = 0;
        exitX = N - 2;
        exitY = M - 1;

        maze[entranceX][entranceY] = ROAD;
        maze[exitX][exitY] = ROAD;
    }

    public int N() {
        return N;
    }

    public int M() {
        return M;
    }

    public int getEntranceX() {
        return entranceX;
    }

    public int getEntranceY() {
        return entranceY;
    }

    public int getExitX() {
        return exitX;
    }

    public int getExitY() {
        return exitY;
    }

    public boolean inArea(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
