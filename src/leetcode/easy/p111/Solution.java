package src.leetcode.easy.p111;

import src.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int minDepth(TreeNode root) {
        int res = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                if (node.left == null && node.right == null) return res;
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
            }
        }
        return res;
    }
}
