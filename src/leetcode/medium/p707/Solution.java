package src.leetcode.medium.p707;

class ListNode {
    int val;
    ListNode next;

    ListNode(int value) {
        val = value;
    }
}

class MyLinkedList {
    ListNode head;
    int size;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    /**
     * 0, 1
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode cur = head;
        while (index >= 0) {
            cur = cur.next;
            index--;
        }
        return cur.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    // 0, 1

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            ListNode node = new ListNode(val);
            node.next = head.next;
            head.next = node;
            size++;
        } else if (index <= size) {
            ListNode cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            ListNode node = new ListNode(val);
            node.next = cur.next;
            cur.next = node;
            size++;
        }
    }

    /**
     * 0, 1
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode cur = head;
        while (index > 0) {
            index--;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        size--;
    }
}
