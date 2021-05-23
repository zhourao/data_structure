package com.code.game.sort.merge;

import java.util.Arrays;

/**
 * TODO:
 *
 * @author zhourao
 * @date 2021/5/22
 */
public class MergeSortData {

    public int[] numbers;

    /**
     * 左边界、右边界
     */
    public int l, r;

    /**
     * 合并索引
     */
    public int mergeIndex;

    public MergeSortData(int N, int randomBound) {
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = (int) (Math.random() * randomBound) + 1;
        }
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
}
