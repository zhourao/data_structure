package com.code.art.leetcode;

/**
 * 描述: 题目24：https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 *
 * @author zhourao
 * @create 2020-10-13 2:17 下午
 */
public class Code0024 {

    /**
     * Definition for singly-linked list.
     */
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

    /**
     * 用栈实现
     */
    public static ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next != null) {
            //cur->①->②->③ ①
            ListNode ln = cur.next;
            //cur->②->③  ①
            cur.next = cur.next.next;
            //cur->②->③  ①->③
            ln.next = cur.next.next;
            //cur->②->①->③
            cur.next.next = ln;
            cur = ln;
        }
        return dummyHead.next;
    }

    public static ListNode swapPairs2(ListNode head) {
        // 递归到底 head=null;head->null
        if (head == null || head.next == null)
            return head;
        //从第3个链表往后进行交换
        //①->②->(④->③) third=(④->③)
        ListNode third = swapPairs2(head.next.next);
        //①->②->(④->③) ②
        ListNode second = head.next;
        //①->(④->③) ②
        head.next = third;
        //②->①->(④->③)
        second.next = head;
        //(②->①->(④->③))
        return second;
    }

    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ln1.next = ln2;
        ListNode ln3 = new ListNode(3);
        ln2.next = ln3;
        ListNode ln4 = new ListNode(4);
        ln3.next = ln4;
        System.out.println(ln1);

        System.out.println(swapPairs(ln1));
    }
}