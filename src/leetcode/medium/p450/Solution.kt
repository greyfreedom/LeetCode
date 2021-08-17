package src.leetcode.medium.p450

import src.common.TreeNode

class Solution {
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        var node = root
        if (node == null) return null
        if (node.`val` == key) {
            if (node.left == null) {
                return node.right
            } else if (node.right == null) {
                return node.left
            } else {
                var cur = node.right
                while (cur.left != null) {
                    cur = cur.left
                }
                cur.left = node.left
                return node.right
            }
        } else if (node.`val` > key) {
            node.left = deleteNode(node.left, key)
        } else {
            node.right = deleteNode(node.right, key)
        }
        return node
    }
}