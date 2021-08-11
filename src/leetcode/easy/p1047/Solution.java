package src.leetcode.easy.p1047;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new LinkedList<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }
        return builder.toString();
    }
}
