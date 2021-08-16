package src.leetcode.easy.p501;

import src.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    List<Integer> result = new ArrayList<>();
    TreeNode pre = null;
    int count = 0;
    int max = 0;

    public int[] findMode(TreeNode root) {
        traversal(root);
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    private void traversal(TreeNode node) {
        if (node == null) return;
        traversal(node.left);
        if (pre == null || node.val != pre.val) {
            count = 1;
        } else {
            count++;
        }
        if (count > max) {
            max = count;
            result.clear();
            result.add(node.val);
        } else if (count == max) {
            result.add(node.val);
        }
        pre = node;
        traversal(node.right);
    }
}
