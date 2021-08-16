package src.leetcode.easy.p235

import src.common.TreeNode

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (p == null || q == null) return null
        var node = root
        while (node != null) {
            node = if (node.`val` > p.`val` && node.`val` > q.`val`) {
                node.left
            } else if (node.`val` < p.`val` && node.`val` < q.`val`) {
                node.right
            } else {
                return node
            }
        }
        return null
    }
}