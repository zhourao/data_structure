package com.code.game.maze_generalization.non_recursive_dfs;

/**
 * 描述: 位置信息
 *
 * @author zhourao
 * @create 2021-06-11 10:58 下午
 */
public class Position {

    private int x, y;
    private Position prev;

    public Position(int x, int y, Position prev) {
        this.x = x;
        this.y = y;
        this.prev = prev;
    }

    public Position(int x, int y) {
        this(x, y, null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position getPrev() {
        return prev;
    }
}
