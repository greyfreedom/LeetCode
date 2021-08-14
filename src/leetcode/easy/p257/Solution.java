package src.leetcode.easy.p257;

import src.common.TreeNode;

import java.util.*;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        List<Integer> path = new LinkedList<>();
        if (root == null) return result;
        findPath(root, path, result);
        return result;
    }

    private void findPath(TreeNode node, List<Integer> path, List<String> result) {
        path.add(node.val);
        if (node.left == null && node.right == null) {
            StringBuilder builder = new StringBuilder();
            boolean first = true;
            for (Integer item : path) {
                if (first) {
                    first = false;
                    builder.append(item);
                } else {
                    builder.append("->").append(item);
                }

            }
            result.add(builder.toString());
            return;
        }
        if (node.left != null) {
            findPath(node.left, path, result);
            path.remove(path.size() - 1);
        }
        if (node.right != null) {
            findPath(node.right, path, result);
            path.remove(path.size() - 1);
        }
    }
}
