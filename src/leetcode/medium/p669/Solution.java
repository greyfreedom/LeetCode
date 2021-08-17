package src.leetcode.medium.p669;

import src.common.TreeNode;

class Solution {
    public TreeNode trimBST2(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) {
            return trimBST2(root.right, low, high);
        } else if (root.val > high) {
            return trimBST2(root.left, low, high);
        } else {
            root.left = trimBST2(root.left, low, high);
            root.right = trimBST2(root.right, low, high);
            return root;
        }
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        while (root != null && (root.val < low || root.val > high)) {
            if (root.val < low) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        TreeNode cur = root;
        while (cur != null) {
            while (cur.left != null && (cur.left.val < low)) {
                cur.left = cur.left.right;
            }
            cur = cur.left;
        }
        cur = root;
        while (cur != null) {
            while (cur.right != null && (cur.right.val > high)) {
                cur.right = cur.right.left;
            }
            cur = cur.right;
        }
        return root;
    }
}
