package src.leetcode.medium.p701

import src.common.TreeNode

class Solution {
    fun insertIntoBST2(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) {
            return TreeNode(`val`)
        }
        if (root.`val` > `val`) {
            root.left = insertIntoBST2(root.left, `val`)
        } else {
            root.right = insertIntoBST2(root.right, `val`)
        }
        return root
    }

    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
        var cur = root
        var pre: TreeNode? = null
        while (cur != null) {
            pre = cur
            cur = if (cur.`val` > `val`) cur.left else cur.right
        }
        return if (pre != null) {
            if (pre.`val` > `val`) {
                pre.left = TreeNode(`val`)
            } else {
                pre.right = TreeNode(`val`)
            }
            root
        } else {
            TreeNode(`val`)
        }
    }
}