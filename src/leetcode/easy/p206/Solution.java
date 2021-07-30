package src.leetcode.easy.p206;

import src.common.ListNode;

// 1, 2
class Solution {
    public ListNode reverseList1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        return reverse(head);
    }

    private ListNode reverse(ListNode node) {
        if (node.next == null) {
            return node;
        }
        ListNode head = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return head;
    }
}
