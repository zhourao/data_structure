package com.code.art.leetcode;

/**
 * 描述: add-two-numbers
 *
 * @author zhourao
 * @create 2021-07-05 11:39 上午
 */
public class Code0002 {

    //Definition for singly-linked list.
    public class ListNode {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode lnDummy = new ListNode(0);
        ListNode lnCur = lnDummy;

        ListNode l1Cur = l1;
        ListNode l2Cur = l2;
        int nexVal = 0;
        while (l1Cur != null || l2Cur != null) {
            int sum = (l1Cur == null ? 0 : l1Cur.val) + (l2Cur == null ? 0 : l2Cur.val) + nexVal;
            nexVal = sum / 10;

            lnCur.next = new ListNode(sum % 10);
            l1Cur = l1Cur == null ? null : l1Cur.next;
            l2Cur = l2Cur == null ? null : l2Cur.next;

            lnCur = lnCur.next;
        }
        if (nexVal == 1) {
            lnCur.next = new ListNode(1);
        }
        return lnDummy.next;
    }

}
