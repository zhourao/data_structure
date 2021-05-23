package com.code.game.sort.heap;

import com.code.game.template.AlgoVisHelper;

import java.awt.*;
import java.util.Arrays;

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
    private static int DELAY = 20;

    /**
     * 数据
     */
    private HeapSortData data;

    /**
     * 视图
     */
    private AlgoFrame frame;

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N) {
        //初始化数据
        data = new HeapSortData(N, sceneHeight);


        //初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Merge Sort Visualization", sceneWidth, sceneHeight);
            new Thread(() -> {
                run();
            }).start();
        });
    }

    /**
     * 动画逻辑
     */
    private void run() {
        setData(data.N());

        // 建堆
        for (int i = (data.N() - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(data.N(), i);
        }

        // 堆排序
        for (int i = data.N() - 1; i > 0; i--) {
            data.swap(0, i);
            shiftDown(i, 0);
            setData(i);
        }

        setData(0);
    }

    private void shiftDown(int n, int k) {

        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && data.get(j + 1) > data.get(j)) {
                j += 1;
            }

            if (data.get(k) >= data.get(j)) {
                break;
            }

            data.swap(k, j);
            setData(data.heapIndex);

            k = j;
        }
    }

    private void setData(int heapIndex) {
        data.heapIndex = heapIndex;

        frame.render(data);
        AlgoVisHelper.pause(DELAY);
    }

    public static void main(String[] args) {
        int sceneWidth = 800;
        int sceneHeight = 800;
        int N = 100;

        //TODO:根据需要设置其他参数,初始化visualizer

        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight, N);
    }
}
