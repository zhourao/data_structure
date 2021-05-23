package com.code.game.sort.insertion;

import java.util.Arrays;

/**
 * TODO:
 *
 * @author zhourao
 * @date 2021/5/22
 */
public class InsertionSortData {

    public enum Type {
        /**
         *
         */
        Default,
        /**
         *
         */
        NearlyOrdered
    }

    private int[] numbers;

    /**
     * [0...orderedIndex)是有序的
     */
    public int orderedIndex = -1;

    /**
     * 当前正在比较的元素索引
     */
    public int currentIndex = -1;

    public InsertionSortData(int N, int randomBound, Type dataType) {
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = (int) (Math.random() * randomBound) + 1;
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

    public InsertionSortData(int N, int randomBound) {
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
