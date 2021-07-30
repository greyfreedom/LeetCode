package src.leetcode.medium.p19;

import src.common.ListNode;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmpHead = new ListNode();
        tmpHead.next = head;
        ListNode fast = tmpHead, slow = tmpHead;
        for (int i = 0; i < n; i++) {
            fast =fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return tmpHead.next;
    }
}
