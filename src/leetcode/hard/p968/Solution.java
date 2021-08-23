package src.leetcode.hard.p968;

import src.common.TreeNode;

class Solution {
    // 0 无覆盖
    // 1 有摄像头
    // 2 有覆盖
    private int count = 0;

    public int minCameraCover(TreeNode root) {
        if (travel(root) == 0) {
            count++;
        }
        return count;
    }

    private int travel(TreeNode node) {
        if (node == null) return 2;
        int left = travel(node.left);
        int right = travel(node.right);
        if (left == 0 || right == 0) {
            count++;
            return 1;
        }
        if (left == 1 || right == 1) return 2;
        if (left == 2 && right == 2) return 0;
        return 2;
    }
}