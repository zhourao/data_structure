package com.code.art.leetcode;

/**
 * 描述:删除排序链表中的重复元素 II https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 *
 * @author zhourao
 * @create 2021-08-08 12:00 上午
 */
public class Code0082 {


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


    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode root = new ListNode(1, new ListNode(1, new ListNode(1,
                new ListNode(2, new ListNode(2, new ListNode(2,
                        new ListNode(3, new ListNode(4))))))));
        ListNode result = deleteDuplicates(root);
        System.out.println(result);
    }
}