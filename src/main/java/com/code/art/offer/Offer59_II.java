package com.code.art.offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 描述:队列的最大值
 *https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 *
 * @author zhourao
 * @create 2021-04-16 10:01 上午
 */
public class Offer59_II {

    /**
     * 【题目】队列的最大值
     * 【题目说明】
     * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
     * 若队列为空，pop_front 和 max_value 需要返回 -1
     * 【示例1】
     * 输入:
     * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
     * [[],[1],[2],[],[],[]]
     * 输出: [null,null,null,2,1,2]
     * 【示例2】
     *  输入:
     * ["MaxQueue","pop_front","max_value"]
     * [[],[],[]]
     * 输出: [null,-1,-1]
     */
    public Offer59_II() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }


    Queue<Integer> queue;
    Deque<Integer> deque;

    public int max_value() {
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }
    public void push_back(int value) {
        queue.offer(value);
        while(!deque.isEmpty() && deque.peekLast() < value)
            deque.pollLast();
        deque.offerLast(value);
    }
    public int pop_front() {
        if(queue.isEmpty()) return -1;
        if(queue.peek().equals(deque.peekFirst()))
            deque.pollFirst();
        return queue.poll();
    }


    public static void main(String[] args) {

    }
}