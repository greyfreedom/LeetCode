package src.leetcode.easy.p572;

import src.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
    // 递归
    public boolean isSubtree2(TreeNode root, TreeNode subRoot) {
        if (isSame(root, subRoot)) {
            return true;
        } else {
            if (root == null) return false;
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
    }

    private boolean isSame(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null || node1.val != node2.val) {
            return false;
        } else {
            return isSame(node1.left, node2.left) && isSame(node1.right, node2.right);
        }
    }

    int lNull = 0, rNull = 0, max = Integer.MIN_VALUE;

    // 迭代 + KMP
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        List<Integer> treeOrder = new ArrayList<>();
        List<Integer> subTreeOrder = new ArrayList<>();
        getMax(root);
        lNull = max +1;
        preOrder(root, treeOrder);
        preOrder(subRoot, subTreeOrder);
        return kmp(treeOrder, subTreeOrder);
    }

    private void getMax(TreeNode node) {
        max = Math.max(max, node.val);
        if (node.left != null) getMax(node.left);
        if (node.right != null) getMax(node.right);
    }

    private void preOrder(TreeNode root, List<Integer> result) {
        Deque<TreeNode> stack = new LinkedList<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node == null ? lNull : node.val);
            if (node != null) {
                stack.push(node.right);
                stack.push(node.left);
            }
        }
    }

    private boolean kmp(List<Integer> str, List<Integer> sub) {
        if (sub == null || sub.size() <= 0) {
            return true;
        }
        int lenStr = str.size();
        int lenSub = sub.size();
        int j = 0;
        int[] next = getNext(sub);
        for (int i = 0; i < lenStr; i++) {
            while (j > 0 && !str.get(i).equals(sub.get(j))) {
                j = next[j - 1];
            }
            if (str.get(i).equals(sub.get(j))) {
                j++;
            }
            if (j == lenSub) {
                return true;
            }
        }
        return false;
    }

    private int[] getNext(List<Integer> sub) {
        int len = sub.size();
        int[] next = new int[len];
        int j = 0;
        next[0] = j;
        for (int i = 1; i < len; i++) {
            while (j > 0 && !sub.get(i).equals(sub.get(j))) {
                j = next[j - 1];
            }
            if (sub.get(i).equals(sub.get(j))) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode root = new TreeNode(1, node1, node2);

        TreeNode sub = new TreeNode(2);
        System.out.println(solution.isSubtree(root, sub));
    }
}