package com.code.game.sort.quick;

import java.util.Arrays;

/**
 * TODO:
 *
 * @author zhourao
 * @date 2021/5/22
 */
public class QuickSortData {

    public enum Type {
        /**
         * 默认：随机
         */
        Default,
        /**
         * 近乎有序
         */
        NearlyOrdered,
        /**
         * 几乎相同
         */
        Identical
    }

    /**
     * 数据存储
     */
    public int[] numbers;

    /**
     * 左边界、右边界
     */
    public int l, r;

    /**
     * 当前中心点
     */
    public int curPivot;

    /**
     * 当前元素
     */
    public int curElement;
    public boolean[] fixedPivots;

    public QuickSortData(int N, int randomBound, Type dataType) {
        numbers = new int[N];
        fixedPivots = new boolean[N];

        int lBound = 1;
        int rBound = randomBound;

        if (dataType == Type.Identical) {
            int avgNumber = (lBound + rBound) / 2;
            lBound = avgNumber;
            rBound = avgNumber;
        }

        for (int i = 0; i < N; i++) {
            numbers[i] = (int) (Math.random() * (rBound - lBound + 1)) + lBound;
            fixedPivots[i] = false;
        }
        if (dataType == Type.NearlyOrdered) {
            Arrays.sort(numbers);
            int swapTime = (int) (N * 0.02);
            for (int i = 0; i < swapTime; i++) {
                int a = (int) (Math.random() * N);
                int b = (int) (Math.random() * N);
                swap(a, b);
            }
        }

    }

    public QuickSortData(int N, int randomBound) {
        this(N, randomBound, Type.Default);
    }

    public int N() {
        return numbers.length;
    }

    public int get(int index) {
        if (index < 0 || index >= numbers.length) {
            throw new IllegalArgumentException("Invalid index to access Sort Data.");
        }
        return numbers[index];
    }

    public void swap(int i, int j) {
        int t = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = t;
    }
}
