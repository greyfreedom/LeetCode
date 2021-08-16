package src.leetcode.medium.p106

import src.common.TreeNode

// inorder 9,3,15,20,7   postorder 9,15,7,20,3
class Solution {
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        return build(inorder, 0, inorder.size - 1, postorder, 0, postorder.size - 1)
    }

    private fun build(inorder: IntArray, inStart: Int, inEnd: Int, postorder: IntArray, postStart: Int, postEnd: Int): TreeNode? {
        if (inorder.isEmpty()) return null
        if (inStart > inEnd || postStart > postEnd) return null
        var node = TreeNode()
        val nodeVal = postorder[postEnd]
        node.`val` = nodeVal

        var indexInOrder: Int = 0
        for (i in inStart..inEnd) {
            if (inorder[i] == nodeVal) {
                indexInOrder = i
            }
        }
        var leftSize = indexInOrder - inStart
        var rightSize = inEnd - indexInOrder
        node.left = build(inorder, inStart, indexInOrder - 1, postorder, postStart, postStart + leftSize - 1)
        node.right = build(inorder, indexInOrder + 1, inEnd, postorder, postStart + leftSize, postEnd - 1)
        return node
    }
}