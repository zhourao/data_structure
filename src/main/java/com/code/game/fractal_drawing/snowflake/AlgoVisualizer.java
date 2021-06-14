package com.code.game.fractal_drawing.snowflake;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
    private static int DELAY = 40;

    /**
     * 数据
     */
    private FractalData data;

    /**
     * 视图
     */
    private AlgoFrame frame;

    public AlgoVisualizer(int depth, int side) {
        data = new FractalData(depth);
        int sceneWidth = side;
        int sceneHeight = side / 3;

        //初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Fractal Visualizer", sceneWidth, sceneHeight);
            frame.addKeyListener(new AlgoKeyListener());
            new Thread(() -> {
                run();
            }).start();
        });
    }

    /**
     * 动画逻辑
     */
    private void run() {
        setData(data.depth);
    }

    private void setData(int depth) {
        data.depth = depth;
        frame.render(data);
        AlgoVisHelper.pause(DELAY);
    }

    public void addAlgoKeyListener() {
        frame.addKeyListener(new AlgoKeyListener());
    }

    private class AlgoKeyListener extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent event) {
            //System.out.println("Key released:" + event);
            if (event.getKeyChar() >= '0' && event.getKeyChar() <= '9') {
                int depth = event.getKeyChar() - '0';
                setData(depth);
            }
        }
    }

    public static void main(String[] args) {
        int depth = 6;
        int side = 900;

        AlgoVisualizer vis = new AlgoVisualizer(depth, side);
    }
}
