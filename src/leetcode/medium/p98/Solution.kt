package src.leetcode.medium.p98

import src.common.TreeNode
import java.util.*

class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        val inOrder = getInorder(root)
        if (inOrder.size <= 1) return true
        for (i in 1 until inOrder.size) {
            if (inOrder[i] <= inOrder[i - 1]) {
                return false
            }
        }
        return true
    }

    private fun getInorder(root: TreeNode?): List<Int> {
        val resultArray = mutableListOf<Int>()
        if (root == null) return resultArray
        val stack: Deque<TreeNode> = ArrayDeque()
        var cur = root
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur)
                cur = cur.left
            }
            val node = stack.pop()
            resultArray.add(node.`val`)
            if (node.right != null) {
                cur = node.right
            }
        }
        return resultArray
    }
}