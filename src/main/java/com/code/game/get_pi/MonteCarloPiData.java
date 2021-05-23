package com.code.game.get_pi;

import java.awt.*;
import java.util.LinkedList;

/**
 * 蒙特卡洛
 *
 * @author zhourao
 * @date 2021/5/22
 */
public class MonteCarloPiData {

    private Circle circle;

    private LinkedList<Point> points;
    private int insideCircle = 0;

    public MonteCarloPiData(Circle circle) {
        this.circle = circle;
        points = new LinkedList<>();
    }

    public Circle getCircle() {
        return this.circle;
    }

    public Point getPoint(int i) {
        if (i < 0 || i >= points.size()) {
            throw new IllegalArgumentException("out of bound in getPoint");
        }
        return points.get(i);
    }

    public int getPointsNumber() {
        return points.size();
    }

    public void addPoint(Point p) {
        points.add(p);
        if (circle.contain(p)) {
            insideCircle++;
        }
    }

    public double estimatePi() {
        if (points.size() == 0) {
            return 0.0;
        }

        int circleArea = insideCircle;
        int squareArea = points.size();

        return (double) circleArea * 4 / squareArea;
    }
}
