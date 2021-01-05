package com.code.art.structure.stack;

/**
 * 描述: 基于数组的栈实现
 *
 * @author zhourao
 * @create 2021-01-05 3:27 下午
 */
public class ArrayStack<E> implements Stack<E> {

    private E[] data;
    private int size;

    public ArrayStack() {
        this(10);
    }

    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(E e) {
        if (size == data.length)
            resize(2 * data.length);
        data[size] = e;
        size++;
    }

    public E pop() {
        size--;
        E e = data[size];
        data[size] = null; //loitering objects != memory leak
        if (size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return e;
    }

    //将数组空间的容量变成newCapacity大小
    private void resize(int newCapacity) {
        E[] newArray = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = data[i];
        }
        data = newArray;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for (int i = 0; i < data.length; i++) {
            res.append(data[i]);
            if (i != data.length - 1)
                res.append(", ");
        }
        res.append("] top");
        return res.toString();
    }


    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<Integer>();
        for (int i = 0; i < 21; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        for (int i = 0; i < 12; i++) {
            stack.pop();
            System.out.println(stack);
        }
    }
}