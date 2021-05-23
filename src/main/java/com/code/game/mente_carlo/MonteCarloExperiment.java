package com.code.game.mente_carlo;

import com.code.game.get_pi.Circle;
import com.code.game.get_pi.MonteCarloPiData;

import java.awt.*;

/**
 * 蒙特卡洛实验-获取pi值
 *
 * @author zhourao
 * @date 2021/5/22
 */
public class MonteCarloExperiment {

    private int squareSide;

    private int N;

    private int outputInterval = 100;

    public MonteCarloExperiment(int squareSide, int N) {
        if (squareSide <= 0 || N <= 0) {
            throw new IllegalArgumentException("squareSide and N must larger");
        }

        this.squareSide = squareSide;
        this.N = N;
    }

    public void setOutputInterval(int interval) {
        if (interval <= 0) {
            throw new IllegalArgumentException("interval must larger than zero");
        }
        this.outputInterval = outputInterval;
    }


    public void run() {
        Circle circle = new Circle(squareSide / 2, squareSide / 2, squareSide / 2);
        MonteCarloPiData data = new MonteCarloPiData(circle);

        for (int i = 0; i < N; i++) {
            if (i % outputInterval == 0) {
                System.out.println(data.estimatePi());
            }
            int x = (int) (Math.random() * squareSide);
            int y = (int) (Math.random() * squareSide);
            data.addPoint(new Point(x, y));
        }
    }

    public static void main(String[] args) {
        int squareSize = 800;
        int N = 10000000;

        MonteCarloExperiment exp = new MonteCarloExperiment(squareSize, N);
        exp.setOutputInterval(500000);
        exp.run();
    }

}
