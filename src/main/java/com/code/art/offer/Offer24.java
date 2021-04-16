package com.code.art.offer;

/**
 * 描述: 反转链表
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 *
 * @author zhourao
 * @create 2021-04-13 9:53 下午
 */
public class Offer24 {

    /**
     * 【题目】反转链表
     * 【题目说明】
     * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
     * 【示例】
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head, tmp;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
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