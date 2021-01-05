package com.code.art.structure.queue;

/**
 * 描述: 数组循环队列
 *
 * @author zhourao
 * @create 2021-01-05 4:16 下午
 */
public class ArrayLoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    public ArrayLoopQueue() {
        this(10);
    }

    public ArrayLoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1]; // front和end需留1个空间间隔
        front = 0;
        tail = 0;
        size = 0;
    }

    private int getCapacity() {
        return data.length - 1;
    }

    public void enqueue(E e) {
        if ((tail + 1) % data.length == front)
            resize(2 * data.length - 2);
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == (data.length - 1) / 4 && (data.length - 1) / 2 != 0)
            resize((data.length - 1) / 2);
        return ret;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return front == tail;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++)
            newData[i] = data[(i + front) % data.length];
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }


    public static void main(String[] args) {
        ArrayLoopQueue<Integer> queue = new ArrayLoopQueue<Integer>();
        for (int i = 0; i < 30; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 4 != 1) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}