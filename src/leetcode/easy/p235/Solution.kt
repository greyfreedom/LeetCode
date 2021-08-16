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

    fun lowestCommonAncestor2(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }
        return if ((root.`val` >= p!!.`val` && root.`val` <= q!!.`val`) || (root.`val` >= q!!.`val` && root.`val` <= p.`val`)) {
            root
        } else if (root.`val` > p.`val` && root.`val` > q.`val`) {
            lowestCommonAncestor2(root.left, p, q)
        } else {
            lowestCommonAncestor2(root.right, p, q)
        }
    }
}