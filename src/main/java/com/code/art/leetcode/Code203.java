package com.code.art.leetcode;

/**
 * 描述: https://leetcode-cn.com/problems/remove-linked-list-elements/
 *
 * @author zhourao
 * @create 2020-10-14 12:20 下午
 */
public class Code203 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer("[");
            ListNode cur = this;
            while (cur != null) {
                sb.append(cur.val);
                if (cur.next != null) {
                    sb.append(",");
                }
                cur = cur.next;
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode cur = dummyHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                //ListNode ln = cur.next;
                cur.next = cur.next.next;
                //ln.next = null;
            } else
                cur = cur.next;
        }
        return dummyHead.next;
    }

    public static ListNode removeElements2(ListNode head, int val) {
        // 将整个链表想象成head+子链表
        if (head == null)
            return null;
        // 先处理子链表
        head.next = removeElements(head.next, val);
        // 再处理头结点
        return head.val == val ? head.next : head;
    }


    public static void main(String[] args) {
        ListNode ln1 = new ListNode(6);
        ListNode ln2 = new ListNode(2);
        ln1.next = ln2;
        ListNode ln3 = new ListNode(1);
        ln2.next = ln3;
        ListNode ln4 = new ListNode(6);
        ln3.next = ln4;
        ListNode ln5 = new ListNode(5);
        ln4.next = ln5;
        ListNode ln6 = new ListNode(6);
        ln5.next = ln6;
        System.out.println(ln1);

        System.out.println(removeElements2(ln1, 6));
    }
}