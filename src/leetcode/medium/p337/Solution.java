package src.leetcode.medium.p337;

import src.common.TreeNode;

class Solution {
    public int rob(TreeNode root) {
        int[] res = robTree(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robTree(TreeNode node) {
        if (node == null) return new int[]{0, 0};
        int[] left = robTree(node.left);
        int[] right = robTree(node.right);
        int res1 = node.val + left[0] + right[0];
        int res2 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{res1, res2};
    }
}
