package com.code.game.sort.quick2way;

import com.code.game.template.AlgoVisHelper;

import java.awt.*;

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
    private TwoWayQuickSortData data;

    /**
     * 视图
     */
    private AlgoFrame frame;

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N, TwoWayQuickSortData.Type dataType) {
        //初始化数据
        data = new TwoWayQuickSortData(N, sceneHeight, dataType);


        //初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Quick Sort Visualization", sceneWidth, sceneHeight);
            new Thread(() -> {
                run();
            }).start();
        });
    }

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N) {
        this(sceneWidth, sceneHeight, N, TwoWayQuickSortData.Type.Default);
    }

    /**
     * 动画逻辑
     */
    private void run() {
        setData(-1, -1, -1, -1, -1, -1);
        quickSort2Way(0, data.N() - 1);
        setData(-1, -1, -1, -1, -1, -1);
    }

    private void quickSort2Way(int l, int r) {
        if (l > r) {
            return;
        }
        if (l == r) {
            setData(l, r, l, -1, -1, -1);
            return;
        }
        setData(l, r, -1, -1, -1, -1);
        int p = partition(l, r);
        quickSort2Way(l, p - 1);
        quickSort2Way(p + 1, r);
    }


    private int partition(int l, int r) {
        // 对有序数组的优化
        int p = (int) (Math.random() * (r - l + 1)) + l;
        setData(l, r, -1, p, -1, -1);

        data.swap(l, p);
        setData(l, r, -1, l, -1, -1);
        int v = data.get(l);

        int i = l + 1, j = r;
        setData(l, r, -1, l, i, j);
        while (true) {
            while (i <= r && data.get(i) < v) {
                setData(l, r, -1, l, i, j);
                i++;
            }
            while (j >= l && data.get(j) > v) {
                setData(l, r, -1, l, i, j);
                j--;
            }
            if (i > j) {
                break;
            }
            data.swap(i, j);
            i++;
            j--;
            setData(l, r, -1, l, i, j);
        }
        data.swap(l, j);
        setData(l, r, j, -1, -1, -1);
        return j;
    }

    private void setData(int l, int r, int fixedPivot, int curPivot, int curL, int curR) {
        data.l = l;
        data.r = r;
        if (fixedPivot != -1) {
            data.fixedPivots[fixedPivot] = true;
        }
        data.curPivot = curPivot;
        data.curL = curL;
        data.curR = curR;
        frame.render(data);
        AlgoVisHelper.pause(DELAY);
    }

    public static void main(String[] args) {
        int sceneWidth = 800;
        int sceneHeight = 800;
        int N = 100;

        //TODO:根据需要设置其他参数,初始化visualizer

//        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight, N);
        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight, N, TwoWayQuickSortData.Type.Identical);
    }
}
