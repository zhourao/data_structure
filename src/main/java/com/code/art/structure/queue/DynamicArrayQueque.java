package com.code.art.structure.queue;

import com.code.art.structure.array.DynamicArray;

/**
 * 描述: 动态数组队列
 *
 * @author zhourao
 * @create 2021-01-05 3:40 下午
 */
public class DynamicArrayQueque<E> implements Queue<E> {

    private DynamicArray<E> array;

    public DynamicArrayQueque() {
        this(10);
    }

    public DynamicArrayQueque(int capacity) {
        array = new DynamicArray<E>(capacity);
    }

    public void enqueue(E e) {
        array.addLast(e);
    }

    public E dequeue() {
        return array.removeFirst();
    }

    public int getSize() {
        return array.getSize();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        DynamicArrayQueque<Integer> queue = new DynamicArrayQueque<Integer>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}