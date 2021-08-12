package src.leetcode.easy.p94;

import src.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// 迭代实现中序遍历
public class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode tmp = stack.pop();
                res.add(tmp.val);
                cur = tmp.right;
            }
        }
        return res;
    }
}
