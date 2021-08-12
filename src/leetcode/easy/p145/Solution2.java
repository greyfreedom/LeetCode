package src.leetcode.easy.p145;

import src.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// 迭代实现后续遍历
public class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        TreeNode lastVisit = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode tmp = stack.pop();
                if (tmp.right == null) {
                    res.add(tmp.val);
                    lastVisit = tmp;
                } else {
                    if (tmp.right == lastVisit) {
                        res.add(tmp.val);
                        lastVisit = tmp;
                    } else {
                        stack.push(tmp);
                        cur = tmp.right;
                    }
                }
            }
        }
        return res;
    }
}
