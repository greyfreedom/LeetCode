package src.leetcode.medium.p150;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (tokens[i].equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } else if (tokens[i].equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (tokens[i].equals("/")) {
                int b = stack.pop();
                stack.push(stack.pop() / b);
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
}
