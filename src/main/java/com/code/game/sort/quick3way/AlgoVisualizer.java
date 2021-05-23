package com.code.game.sort.quick3way;

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
    private ThreeWayQuickSortData data;

    /**
     * 视图
     */
    private AlgoFrame frame;

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N, ThreeWayQuickSortData.Type dataType) {
        //初始化数据
        data = new ThreeWayQuickSortData(N, sceneHeight, dataType);


        //初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Quick Sort Visualization", sceneWidth, sceneHeight);
            new Thread(() -> {
                run();
            }).start();
        });
    }

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N) {
        this(sceneWidth, sceneHeight, N, ThreeWayQuickSortData.Type.Default);
    }

    /**
     * 动画逻辑
     */
    private void run() {
        setData(-1, -1, -1, -1, -1, -1);
        quickSort3Ways(0, data.N() - 1);
        setData(-1, -1, -1, -1, -1, -1);
    }

    private void quickSort3Ways(int l, int r) {
        if (l > r) {
            return;
        }
        if (l == r) {
            setData(l, r, l, -1, -1, -1);
            return;
        }
        setData(l, r, -1, -1, -1, -1);
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        int p = (int) (Math.random() * (r - l + 1)) + l;
        setData(l, r, -1, p, -1, -1);

        data.swap(l, p);
        int v = data.get(l);
        setData(l, r, -1, l, -1, -1);

        // arr[l+1...lt] < v
        int lt = l;
        // arr[gt...r] > v
        int gt = r + 1;
        // arr[lt+1...i) == v
        int i = l + 1;
        setData(l, r, -1, l, lt, gt);

        while (i < gt) {
            if (data.get(i) < v) {
                data.swap(i, lt + 1);
                i++;
                lt++;
            } else if (data.get(i) > v) {
                data.swap(i, gt - 1);
                gt--;
            } else {// arr[i] == v
                i++;
            }

            setData(l, r, -1, l, i, gt);
        }
        data.swap(l, lt);
        setData(l, r, lt, -1, -1, -1);

        quickSort3Ways(l, lt - 1);
        quickSort3Ways(gt, r);
    }

    private void setData(int l, int r, int fixedPivot, int curPivot, int curL, int curR) {
        data.l = l;
        data.r = r;
        if (fixedPivot != -1) {
            data.fixedPivots[fixedPivot] = true;
            int i = fixedPivot;
            while (i < data.N() && data.get(i) == data.get(fixedPivot)) {
                data.fixedPivots[i] = true;
                i++;
            }
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
//        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight, N, ThreeWayQuickSortData.Type.NearlyOrdered);
        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight, N, ThreeWayQuickSortData.Type.Identical);
    }
}
