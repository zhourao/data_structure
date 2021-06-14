package com.code.game.fractal_drawing.sierpinski_triangle;

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
    private FractalData data;

    public void render(FractalData data) {
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
            drawFractal(g2d, 0, canvasHeight, canvasWidth, 0);
        }

        private void drawFractal(Graphics2D g, int Ax, int Ay, int side, int depth) {
            if (side <= 1) {
                AlgoVisHelper.setColor(g, AlgoVisHelper.INDIGO);
                AlgoVisHelper.fillRectangle(g, Ax, Ay, 1, 1);
                return;
            }

            int Bx = Ax + side;
            int By = Ay;

            int h = (int) (Math.sin(60.0 * Math.PI / 180.0) * side);
            int Cx = Ax + side / 2;
            int Cy = Ay - h;

            if (depth == data.depth) {
                AlgoVisHelper.setColor(g, AlgoVisHelper.INDIGO);
                AlgoVisHelper.fillTriangle(g, Ax, Ay, Bx, By, Cx, Cy);
                return;
            }

            int AB_centerx = (Ax + Bx) / 2;
            int AB_centery = (Ay + By) / 2;

            int AC_centerx = (Ax + Cx) / 2;
            int AC_centery = (Ay + Cy) / 2;

            drawFractal(g, Ax, Ay, side / 2, depth + 1);
            drawFractal(g, AC_centerx, AC_centery, side / 2, depth + 1);
            drawFractal(g, AB_centerx, AB_centery, side / 2, depth + 1);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}
