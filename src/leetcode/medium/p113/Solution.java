package src.leetcode.medium.p113;

import src.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> path = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        path.add(root.val);
        findPath(root, targetSum - root.val, path, result);
        return result;
    }

    private void findPath(TreeNode node, int sum, List<Integer> path, List<List<Integer>> result) {
        if (node.left == null && node.right == null) {
            if (sum == 0) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        if (node.left != null) {
            path.add(node.left.val);
            findPath(node.left, sum - node.left.val, path, result);
            path.remove(path.size() - 1);
        }
        if (node.right != null) {
            path.add(node.right.val);
            findPath(node.right, sum - node.right.val, path, result);
            path.remove(path.size() - 1);
        }
    }
}
