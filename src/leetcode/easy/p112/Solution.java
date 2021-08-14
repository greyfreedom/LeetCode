package src.leetcode.easy.p112;

import src.common.TreeNode;

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return findPath(root, targetSum - root.val);
    }

    private boolean findPath(TreeNode node, int value) {
        if (node.left == null && node.right == null) {
            return value == 0;
        }
        boolean res = false;
        if (node.left != null) {
            res = findPath(node.left, value - node.left.val);
        }
        if (res) return true;
        if (node.right != null) {
            res = findPath(node.right, value - node.right.val);
        }
        return res;
    }
}
