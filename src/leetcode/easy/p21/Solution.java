package src.leetcode.easy.p21;

import src.common.ListNode;

// 测试
class Solution {
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        while (l1 != null || l2 != null) {
            int a = l1 != null ? l1.val : 200;
            int b = l2 != null ? l2.val : 200;
            int val = Math.min(a, b);
            if (head == null) {
                head = tail = new ListNode(val);
            } else {
                tail.next = new ListNode(val);
                tail = tail.next;
            }
            if (a <= b) {
                l1 = l1.next;
            } else {
                l2 = l2.next;
            }
        }
        return head;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        mergeRecursion(head, l1, l2);
        return head.next;
    }

    private void mergeRecursion(ListNode head, ListNode l1, ListNode l2) {
        if (l1 != null && l2 != null) {
            head.next = l1.val <= l2.val ? l1 : l2;
            ListNode left = l1.val <= l2.val ? l1.next : l1;
            ListNode right = l1.val <= l2.val ? l2 : l2.next;
            mergeRecursion(head.next, left, right);
        } else if (l1 != null) {
            head.next = l1;
        } else if (l2 != null) {
            head.next = l2;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode tail = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1 != null ? l1 : l2;
        return head.next;
    }
}
