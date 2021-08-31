package com.code.art.leetcode;

import java.util.Random;

/**
 * 描述: 打乱数组 https://leetcode-cn.com/problems/shuffle-an-array/
 *
 * @author zhourao
 * @create 2021-08-25 5:40 下午
 */
public class Code0384 {

    private int[] array;
    private int[] original;

    Random rand = new Random();

    public Code0384(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }
}
