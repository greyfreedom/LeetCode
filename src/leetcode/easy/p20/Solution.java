package src.leetcode.easy.p20;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.peek() != c) {
                return false;
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
