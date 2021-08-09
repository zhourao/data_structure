package com.code.art.leetcode;

import com.code.art.leetcode.Code0092.ListNode;

import java.util.Stack;

/**
 * 描述:
 *
 * @author zhourao
 * @create 2021-07-06 5:38 下午
 */
public class Code0092 {

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public String toString() {
            ListNode node = this;
            StringBuffer s = new StringBuffer("");
            s.append(node.val);
            while (node.next != null) {
                node = node.next;
                s.append(node.val);
            }
            return s.toString();
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        Stack<ListNode> stack = new Stack<>();
        ListNode dummyHead = new ListNode(0, head);
        ListNode curNode = dummyHead;

        int i = 1;
        while (curNode.next != null && i <= right) {
            if (i >= left && i <= right) {
                stack.push(curNode.next);
                curNode.next = curNode.next.next;
            } else {
                curNode = curNode.next;
            }
            i++;
        }
        while (!stack.isEmpty()) {
            ListNode pop = stack.pop();
            pop.next = curNode.next;
            curNode.next = pop;
            curNode = curNode.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3,
                new ListNode(4, new ListNode(5, null)))));
        System.out.println(reverseBetween(head, 2, 4));
    }
}
