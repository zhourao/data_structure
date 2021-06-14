package com.code.game.move_box;

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
    private static int DELAY = 40;

    private static int blockSide = 80;

    /**
     * 数据
     */
    private GameData data;

    /**
     * 视图
     */
    private AlgoFrame frame;

    public AlgoVisualizer(String filename) {
        //初始化数据
        data = new GameData(filename);
        int sceneWidth = data.M() * blockSide;
        int sceneHeight = data.N() * blockSide;

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
        setData();

        if (data.solve())
            System.out.println("The game has a solution!");
        else
            System.out.println("The game does NOT have a solution.");
    }


    private void setData() {
        frame.render(data);
        AlgoVisHelper.pause(DELAY);
    }

    public static void main(String[] args) {
        // String filename = "src/main/resources/move_box/boston_09.txt";
        String filename = "src/main/resources/move_box/boston_16.txt";

        AlgoVisualizer visualizer = new AlgoVisualizer(filename);
    }
}
