package com.code.game.maze_generalization.random;

import com.code.art.structure.linkedlist.LinkedList;

/**
 * 描述: 随机Queue
 *
 * @author zhourao
 * @create 2021-06-12 8:23 上午
 */
public class RandomQueue<E> {

    private LinkedList<E> queue;

    public RandomQueue() {
        queue = new LinkedList<E>();
    }

    public void add(E e) {
        if (Math.random() < 0.5) {
            queue.addLast(e);
        } else {
            queue.addLast(e);
        }
    }

    public E remove() {
        if (queue.getSize() == 0) {
            throw new IllegalArgumentException("There's no element to remove in Random Queue");
        }

        if (Math.random() < 0.5) {
            return queue.removeFirst();
        } else {
            return queue.removeLast();
        }
    }

    public int size() {
        return queue.getSize();
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
