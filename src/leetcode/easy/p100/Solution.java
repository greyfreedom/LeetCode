package src.leetcode.easy.p100;

import src.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null || p.val != q.val) {
            return false;
        } else {
            boolean leftSame = isSameTree(p.left, q.left);
            boolean rightSame = isSameTree(p.right, q.right);
            return leftSame && rightSame;
        }
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(p);
        queue.addLast(q);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.removeFirst();
            TreeNode node2 = queue.removeFirst();
            if (node1 == null && node2 == null) {
                continue;
            } else if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            } else {
                queue.addLast(node1.left);
                queue.addLast(node2.left);
                queue.addLast(node1.right);
                queue.addLast(node2.right);
            }
        }
        return true;
    }
}
