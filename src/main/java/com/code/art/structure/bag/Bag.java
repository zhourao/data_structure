package com.code.art.structure.bag;

import java.util.Iterator;

/**
 * 描述: 邻接表
 *
 * @author zhourao
 * @create 2021-01-26 3:31 下午
 */
public class Bag<E> implements Iterable<E> {

    private Node first; //链表的首节点

    private class Node {
        E item;
        Node next;
    }

    public void add(E e) {//和Stack的push()方法完全相同
        Node oldfirst = first;
        first = new Node();
        first.item = e;
        first.next = oldfirst;
    }

    public Iterator<E> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<E> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {

        }

        public E next() {
            E e = current.item;
            current = current.next;
            return e;
        }
    }
}