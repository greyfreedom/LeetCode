package src.leetcode.medium.p24;

import src.common.ListNode;

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tmpHead = new ListNode();
        tmpHead.next = head;
        ListNode cur = tmpHead;
        while (cur.next != null && cur.next.next != null) {
            ListNode tmp1 = cur.next;
            ListNode tmp2 = cur.next.next.next;

            cur.next = cur.next.next;
            cur.next.next = tmp1;
            tmp1.next = tmp2;
            cur = cur.next.next;
        }
        return tmpHead.next;
    }
}
