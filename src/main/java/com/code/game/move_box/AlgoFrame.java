package com.code.game.move_box;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

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
    private GameData data;

    public void render(GameData data) {
        this.data = data;
        repaint();
    }

    private class AlgoCanvas extends JPanel {

        private ArrayList<Color> colorList;
        private HashMap<Character, Color> colorMap;

        public AlgoCanvas() {
            // 双缓存
            super(true);

            colorList = new ArrayList<Color>();
            colorList.add(AlgoVisHelper.RED);
            colorList.add(AlgoVisHelper.PURPLE);
            colorList.add(AlgoVisHelper.BLUE);
            colorList.add(AlgoVisHelper.TEAL);
            colorList.add(AlgoVisHelper.LIGHT_GREEN);
            colorList.add(AlgoVisHelper.LIME);
            colorList.add(AlgoVisHelper.AMBER);
            colorList.add(AlgoVisHelper.DEEP_ORANGE);
            colorList.add(AlgoVisHelper.BROWN);
            colorList.add(AlgoVisHelper.BLUE_GREY);

            colorMap = new HashMap<Character, Color>();
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;

            int w = canvasWidth / data.M();
            int h = canvasHeight / data.N();

            Board showBoard = data.getShowBoard();

            for (int i = 0; i < showBoard.N(); i++) {
                for (int j = 0; j < showBoard.M(); j++) {
                    char c = showBoard.getData(i, j);
                    if (c != Board.EMPTY) {

                        if (!colorMap.containsKey(c)) {
                            int sz = colorMap.size();
                            colorMap.put(c, colorList.get(sz));
                        }

                        Color color = colorMap.get(c);
                        AlgoVisHelper.setColor(g2d, color);
                        AlgoVisHelper.fillRectangle(g2d, j * w + 2, i * h + 2, w - 4, h - 4);

                        AlgoVisHelper.setColor(g2d, AlgoVisHelper.WHITE);
                        String text = String.format("( %d , %d )", i, j);
                        AlgoVisHelper.drawText(g2d, text, j * h + h / 2, i * w + w / 2);
                    }
                }
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}
