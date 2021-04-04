package com.code.art.base.sort10;

/**
 * 描述: 计时器
 *
 * @author zhourao
 * @create 2021-01-06 11:42 上午
 */
public class Stopwatch {

    private final long start;

    public Stopwatch() {
        start = System.currentTimeMillis();
    }

    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
}