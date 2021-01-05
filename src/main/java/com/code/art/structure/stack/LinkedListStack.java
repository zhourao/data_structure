package com.code.art.structure.stack;

import com.code.art.structure.linkedlist.LinkedList;

/**
 * 描述: 基于链表的栈
 *
 * @author zhourao
 * @create 2021-01-05 5:09 下午
 */
public class LinkedListStack<E> implements Stack<E> {


    private LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList<E>();
    }

    public void push(E e) {
        list.addFirst(e);
    }

    public E pop() {
        return list.removeFirst();
    }

    public int getSize() {
        return list.getSize();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}