package com.code.game.mine_sweeper;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    private static int DELAY = 5;

    private static int blockSide = 32;

    /**
     * 数据
     */
    private MineSweeperData data;

    /**
     * 视图
     */
    private AlgoFrame frame;
    private static final int d[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public AlgoVisualizer(int N, int M, int mineNumber) {

        data = new MineSweeperData(N, M, mineNumber);
        int sceneHeight = data.N() * blockSide;
        int sceneWidth = data.M() * blockSide;

        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Mine Sweeper", sceneWidth, sceneHeight);

            frame.addMouseListener(new AlgoMouseListener());
            new Thread(() -> {
                run();
            }).start();
        });
    }

    /**
     * 动画逻辑
     */
    private void run() {
        setData(false, -1, -1);
    }

    private void setData(boolean isLeftClick, int x, int y) {
        if (isLeftClick) {
            if (data.inArea(x, y)) {
                if (data.isMine(x, y)) {
                    data.open[x][y] = true;
                } else {
                    data.open(x, y);
                }
            }
        } else {
            if (data.inArea(x, y)) {
                data.flags[x][y] = !data.flags[x][y];
            }
        }

        frame.render(data);
        AlgoVisHelper.pause(DELAY);
    }

    public void addAlgoMouseListener() {
        frame.addMouseListener(new AlgoMouseListener());
    }

    private class AlgoMouseListener extends MouseAdapter {

        @Override
        public void mouseReleased(MouseEvent event) {

            event.translatePoint(
                    -(int) (frame.getBounds().width - frame.getCanvasWidth()),
                    -(int) (frame.getBounds().height - frame.getCanvasHeight())
            );

            Point pos = event.getPoint();

            int w = frame.getCanvasWidth() / data.M();
            int h = frame.getCanvasHeight() / data.N();

            int x = pos.y / h;
            int y = pos.x / w;
            // System.out.println(x + " , " + y);

            if (SwingUtilities.isLeftMouseButton(event))
                setData(true, x, y);
            else if (SwingUtilities.isRightMouseButton(event))
                setData(false, x, y);

        }
    }


    public static void main(String[] args) {
        int N = 20;
        int M = 20;
        int mineNumber = 20;

        AlgoVisualizer vis = new AlgoVisualizer(N, M, mineNumber);
    }
}
