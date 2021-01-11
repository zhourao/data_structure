package com.code.art.structure.heap;

import java.util.Random;

/**
 * 描述: 最大堆
 * TOPN问题比较合适
 *
 * @author zhourao
 * @create 2021-01-11 10:20 上午
 */
public class MaxHeap<E extends Comparable<E>> {

    private E[] data; //数组容器

    private int size; //容器大小

    public MaxHeap(int capacity) {
        data = (E[]) new Comparable[capacity];
    }

    public MaxHeap() {
        this(10);
    }

    public MaxHeap(E[] arr) {
        data = (E[]) new Comparable[arr.length];
        System.arraycopy(arr, 0, data, 0, arr.length); //数组复制
        size = arr.length;
        //heapify
        if (arr.length != 1)
            for (int i = parent(arr.length - 1); i >= 0; i--)
                siftDown(i);
    }


    public void add(E e) {
        if (size == data.length)
            resize(2 * data.length);
        data[size++] = e;
        siftUp(size - 1);
    }

    // 取出堆中最大元素
    public E extractMax() {
        if (size == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");

        E ret = data[0];
        swap(data, 0, size - 1);
        data[--size] = null;
        siftDown(0);

        if (size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return ret;
    }

    //尾部元素上浮
    private void siftUp(int k) {
        while (k > 0 && less(data[parent(k)], data[k])) {
            swap(data, k, parent(k));
            k = parent(k);
        }
    }

    //顶部元素下沉
    private void siftDown(int k) {
        while (leftChild(k) < size) {
            int j = leftChild(k); // 在此轮循环中,data[k]和data[j]交换位置
            if (j + 1 < size && less(data[j], data[j + 1]))
                j++;
            if (!less(data[k], data[j]))
                break;
            swap(data, k, j);
            k = j;
        }
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (index - 1) / 2;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private void swap(E[] a, int i, int j) {
        E t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private boolean less(E v, E w) {
        return v.compareTo(w) < 0;
    }

    // 将数组空间的容量变成newCapacity大小
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Comparable[newCapacity];
        if (size >= 0) System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    public static void main(String[] args) {
        int n = 100;
        Random random = new Random();
        Integer[] testData = new Integer[n];
        for (int i = 0; i < n; i++)
            testData[i] = random.nextInt(100);

        MaxHeap<Integer> heap = new MaxHeap<Integer>(testData);
        for (int i = 0; i < testData.length; i++)
            System.out.print(heap.extractMax() + " ");
    }
}