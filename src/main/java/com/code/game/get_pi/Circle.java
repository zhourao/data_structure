package com.code.game.get_pi;

import java.awt.*;

/**
 * TODO:
 *
 * @author zhourao
 * @date 2021/5/22
 */
public class Circle {


    public int x, y;
    private int r;
    public boolean isFilled = false;

    public Circle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getR() {
        return r;
    }

    public boolean contain(Point p) {
        return (x - p.x) * (x - p.x) + (y - p.y) * (y - p.y) <= r * r;
    }
}
