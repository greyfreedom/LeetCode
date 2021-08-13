package src.leetcode.easy.p110;

import src.common.TreeNode;

class Solution {
    public boolean isBalanced(TreeNode root) {
        return balance(root) != -1;
    }

    private int balance(TreeNode node) {
        if (node == null) return 0;
        int leftH = balance(node.left);
        if (leftH < 0) return -1;
        int rightH = balance(node.right);
        if (rightH < 0) return -1;
        if (Math.abs(leftH - rightH) > 1) {
            return -1;
        } else {
            return Math.max(leftH, rightH) + 1;
        }
    }
}
