package src.leetcode.easy.p203;

import src.common.ListNode;

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode cur = newHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return newHead.next;
    }
}
