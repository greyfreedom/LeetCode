package src.leetcode.hard.p239;

import java.util.ArrayDeque;
import java.util.Deque;

// nums = [1,3,-1,-3,5,3,6,7], k = 3
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MyQueue queue = new MyQueue();
        int len = nums.length - k + 1;
        int[] result = new int[len];
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        result[0] = queue.peek();
        for (int i = k; i < nums.length; i++) {
            queue.remove(nums[i - k]);
            queue.add(nums[i]);
            result[i - k + 1] = queue.peek();
        }
        return result;
    }
}

class MyQueue {
    Deque<Integer> queue = new ArrayDeque<>();

    public void add(int item) {
        while (!queue.isEmpty() && queue.peekLast() < item) {
            queue.removeLast();
        }
        queue.addLast(item);
    }

    public void remove(int item) {
        if (!queue.isEmpty() && queue.peekFirst() == item) {
            queue.removeFirst();
        }
    }

    public int peek() {
        return queue.peekFirst();
    }
}
