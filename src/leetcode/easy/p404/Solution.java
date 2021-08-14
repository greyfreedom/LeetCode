package src.leetcode.easy.p404;

import src.common.TreeNode;

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        return sumOfLeft(root.left, true) + sumOfLeft(root.right, false);
    }

    private int sumOfLeft(TreeNode node, boolean left) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) {
            return left ? node.val : 0;
        }
        return sumOfLeft(node.left, true) + sumOfLeft(node.right, false);
    }
}