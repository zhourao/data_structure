package com.code.art.structure.stack;

import com.code.art.structure.array.DynamicArray;

/**
 * 描述: 基于动态数组的栈
 *
 * @author zhourao
 * @create 2021-01-05 3:21 下午
 */
public class DynamicArrayStack<E> implements Stack<E> {

    /**
     * 动态数组容器
     */
    private DynamicArray<E> array;

    public DynamicArrayStack(int capacity) {
        array = new DynamicArray<E>(capacity);
    }

    public int getSize() {
        return array.getSize();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    public void push(E e) {
        array.addLast(e);
    }

    public E pop() {
        return array.removeLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] top");
        return res.toString();
    }


    public static void main(String[] args) {
        DynamicArrayStack<Integer> stack = new DynamicArrayStack<Integer>(5);
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