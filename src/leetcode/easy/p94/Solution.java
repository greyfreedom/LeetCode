package src.leetcode.easy.p94;

import src.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }

    private void inOrder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inOrder(node.left, res);
        res.add(node.val);
        inOrder(node.right, res);
    }
}
