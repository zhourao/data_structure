package com.code.art.leetcode;

/**
 * 描述: 删除链表的倒数第 N 个结点 https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * @author zhourao
 * @create 2021-08-30 4:51 下午
 */
public class Code0019 {

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
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1, head);
        ListNode curNode = dummyNode;
        for (int i = 0; i < n; i++) head = head.next;
        while (head != null) {
            head = head.next;
            curNode = curNode.next;
        }
        curNode.next = curNode.next.next;
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(4, new ListNode(3, new ListNode(2,
                new ListNode(1))));
        ListNode result = removeNthFromEnd(root, 1);
        System.out.println(result);
    }
}
