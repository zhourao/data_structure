package com.code.art.offer;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 描述: 从尾到头打印链表
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 *
 * @author zhourao
 * @create 2021-04-10 9:28 上午
 */
public class Offer06 {

    /**
     * 【题目】从尾到头打印链表
     * 【题目说明】
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     * 【示例】
     * 输入：head = [1,3,2]
     * 输出：[2,3,1]
     */
    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[0];
        ArrayList<Integer> list = new ArrayList<>();
        reversePrint(head, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = list.get(i);
        return res;
    }

    private void reversePrint(ListNode node, List<Integer> list) {
        if (node == null) return;
        reversePrint(node.next, list);
        list.add(node.val);
    }


    public int[] reversePrint2(ListNode head) {
        if (head == null) return new int[0];
        Stack<Integer> stack = new Stack<>();
        ListNode tmp = head;
        stack.push(tmp.val);
        int count = 1;
        while ((tmp = tmp.next) != null) {
            stack.push(tmp.val);
            count++;
        }

        int[] res = new int[count];
        for (int i = 0; i < res.length; i++)
            res[i] = stack.pop();
        return res;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
    }
}