package src.leetcode.easy.p617

import src.common.TreeNode

class Solution {
    fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
        return build(root1, root2)
    }

    private fun build(node1: TreeNode?, node2: TreeNode?): TreeNode? {
        return if (node1 == null && node2 == null) {
            null
        } else {
            val node = TreeNode((node1?.`val` ?: 0) + (node2?.`val` ?: 0))
            node.left = build(node1?.left, node2?.left)
            node.right = build(node1?.right, node2?.right)
            node
        }
    }
}