package com.code.game.probability_simulation;

import com.code.game.template.AlgoVisHelper;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.util.Arrays;

/**
 * 算法应用视图
 *
 * @author zhourao
 * @date 2021/5/22
 */
public class AlgoVisualizer {

    /**
     * 渲染间隔
     */
    private static int DELAY = 40;

    /**
     * 轮询次数
     */
    private static int K = 50;

    /**
     * 数据
     */
    private int[] money;

    /**
     * 视图
     */
    private AlgoFrame frame;

    public AlgoVisualizer(int sceneWidth, int sceneHeight) {
        //初始化数据
        money = new int[100];
        for (int i = 0; i < money.length; i++) {
            money[i] = 100;
        }
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
        while (true) {
            Arrays.sort(money);
            frame.render(money);
            AlgoVisHelper.pause(DELAY);

            for (int k = 0; k < K; k++) {
                for (int i = 0; i < money.length; i++) {
                    int j = (int) (Math.random() * money.length);
                    money[i] -= 1;
                    money[j] += 1;
                }
            }
        }
    }


    //TODO:根据情况决定是否实现键盘鼠标等交互事件监听器类

    /**
     * 键盘事件
     */
    private class AlgoKeyListener extends KeyAdapter {
    }

    /**
     * 鼠标事件
     */
    private class AlgoMouseListener extends MouseAdapter {
    }

    public static void main(String[] args) {
        int sceneWidth = 1000;
        int sceneHeight = 800;

        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight);
    }
}
