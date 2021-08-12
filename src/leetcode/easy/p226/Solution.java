package src.leetcode.easy.p226;

import src.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public TreeNode invertTree(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            swap(node);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return root;
    }

    private void swap(TreeNode node) {
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }
}
