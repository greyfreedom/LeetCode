package src.leetcode.medium.p513;

import src.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                if (i == 0) {
                    res = node.val;
                }
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
            }
        }
        return res;
    }
}
