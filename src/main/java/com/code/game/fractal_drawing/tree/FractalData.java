package com.code.game.fractal_drawing.tree;

/**
 * 描述: 分形数据
 *
 * @author zhourao
 * @create 2021-06-14 8:27 上午
 */
public class FractalData {

    public int depth;
    public double splitAngle;

    public FractalData(int depth, double splitAngle) {
        this.depth = depth;
        this.splitAngle = splitAngle;
    }
}
