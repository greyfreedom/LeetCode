package src.mianshiti.p0207;

import src.common.ListNode;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = 0, lenB = 0;
        ListNode head = headA;
        while (head != null) {
            lenA++;
            head = head.next;
        }
        head = headB;
        while (head != null) {
            lenB++;
            head = head.next;
        }
        int lenDiff = Math.abs(lenA - lenB);
        if (lenA > lenB) {
            while (lenDiff > 0) {
                lenDiff--;
                headA = headA.next;
            }
        } else if (lenA < lenB) {
            while (lenDiff > 0) {
                lenDiff--;
                headB = headB.next;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
