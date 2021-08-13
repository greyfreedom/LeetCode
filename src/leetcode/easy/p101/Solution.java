package src.leetcode.easy.p101;

import src.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class Solution {
    // 递归
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        } else if (left != null && right == null) {
            return false;
        } else if (left == null && right == null) {
            return true;
        } else {
            if (left.val != right.val) {
                return false;
            } else {
                boolean out = compare(left.left, right.right);
                boolean inner = compare(left.right, right.left);
                return out && inner;
            }
        }
    }

    // 迭代
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        boolean res = true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.right);
        stack.push(root.left);
        while (!stack.isEmpty()) {
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();
            res &= compareNode(left, right);
            if (res) {
                if (left == null) continue;
                stack.push(right.left);
                stack.push(left.right);
                stack.push(right.right);
                stack.push(left.left);
            } else {
                res = false;
                break;
            }
        }
        return res;
    }

    private boolean compareNode(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else {
            return left.val == right.val;
        }
    }
}
