package src.leetcode.medium.p142;

import src.common.ListNode;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode tmp = head;
                while (slow != tmp) {
                    slow = slow.next;
                    tmp = tmp.next;
                }
                return slow;
            }
        }
        return null;
    }
}
