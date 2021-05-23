package com.code.game.sort.heap;

/**
 * 堆排序数据
 *
 * @author zhourao
 * @date 2021/5/22
 */
public class HeapSortData {

    public int[] numbers;
    /**
     * numbers[heapIndex...N) 已经排好序
     */
    public int heapIndex;

    public HeapSortData(int N, int randomBound) {
        numbers = new int[N];
        heapIndex = N;

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


    public void swap(int i, int j) {
        int t = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = t;
    }
}
