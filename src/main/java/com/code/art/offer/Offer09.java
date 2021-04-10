package com.code.art.offer;


import java.util.Stack;

/**
 * 描述: 用两个栈实现队列
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 *
 * @author zhourao
 * @create 2021-04-10 9:28 上午
 */
public class Offer09 {

    /**
     * 【题目】从尾到头打印链表
     * 【题目说明】
     * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
     * (若队列中没有元素，deleteHead操作返回 -1 )
     *
     * 【示例】
     * 输入：
     * ["CQueue","appendTail","deleteHead","deleteHead"]
     * [[],[3],[],[]]
     * 输出：[null,null,3,-1]
     *
     * 输入：
     * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
     * [[],[],[5],[2],[],[]]
     * 输出：[null,-1,null,null,5,2]
     */
    public Offer09() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    private Stack<Integer> pushStack;

    private Stack<Integer> popStack;

    public void appendTail(int value) {
        pushStack.push(value);
    }

    public int deleteHead() {
        if (!popStack.isEmpty()) return popStack.pop();

        while (!pushStack.isEmpty())
            popStack.push(pushStack.pop());

        return popStack.isEmpty() ? -1 : popStack.pop();
    }


    public static void main(String[] args) {
        Offer09 cqueue = new Offer09();
        cqueue.appendTail(3);
        cqueue.deleteHead();
        cqueue.deleteHead();
        cqueue.deleteHead();
    }
}