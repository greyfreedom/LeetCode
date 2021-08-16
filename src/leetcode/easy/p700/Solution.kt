package src.leetcode.easy.p700

import src.common.TreeNode

class Solution {
    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        return if (root == null || root.`val` == `val`) {
            root
        } else if (root.`val` > `val`) {
            searchBST(root.left, `val`)
        } else if (root.`val` < `val`) {
            searchBST(root.right, `val`)
        } else {
            null
        }
    }
}