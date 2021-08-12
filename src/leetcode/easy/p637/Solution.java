package src.leetcode.easy.p637;

import src.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.addLast(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                sum += node.val;
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
            }
            result.add(sum / size);
        }
        return result;
    }
}
