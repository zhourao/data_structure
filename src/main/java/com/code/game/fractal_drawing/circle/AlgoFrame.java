package com.code.game.fractal_drawing.circle;

import javax.swing.*;
import java.awt.*;

/**
 * 算法应用框架
 *
 * @author zhourao
 * @date 2021/5/22
 */
public class AlgoFrame extends JFrame {

    private final int canvasWidth;

    private final int canvasHeight;

    public AlgoFrame(String title, int canvasWidth, int canvasHeight) {
        super(title);
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgoCanvas canvas = new AlgoCanvas();
        setContentPane(canvas);

        setResizable(false);
        pack(); //在setResizable(false)后进行pack()，防止在windows下系统修改frame的尺寸
        // 具体参见：http://coding.imooc.com/learn/questiondetail/26420.html

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public AlgoFrame(String title) {
        this(title, 1024, 768);
    }

    public int getCanvasWidth() {
        return this.canvasWidth;
    }

    public int getCanvasHeight() {
        return this.canvasHeight;
    }

    /**
     * 设置自己的数据
     */
    private CircleData data;

    public void render(CircleData data) {
        this.data = data;
        repaint();
    }

    private class AlgoCanvas extends JPanel {

        public AlgoCanvas() {
            // 双缓存
            super(true);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;

            //抗锯齿
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.addRenderingHints(hints);

            // 具体绘制
            drawCircle(g2d, data.getStartX(), data.getStartY(), data.getStartR(), 0);
        }

        private void drawCircle(Graphics2D g, int x, int y, int r, int depth) {
            if (depth == data.getDepth() || r < 1) {
                return;
            }

            if (depth % 2 == 0) {
                AlgoVisHelper.setColor(g, AlgoVisHelper.RED);
            } else {
                AlgoVisHelper.setColor(g, AlgoVisHelper.LIGHT_BLUE);
            }

            AlgoVisHelper.fillCircle(g, x, y, r);
            drawCircle(g, x, y, r - data.getStep(), depth + 1);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}
