package src.leetcode.easy.p530

import src.common.TreeNode
import kotlin.math.abs
import kotlin.math.min

class Solution {
    fun getMinimumDifference(root: TreeNode?): Int {
        val inOrder = mutableListOf<Int>()
        inOrder(root, inOrder)
        if (inOrder.size <= 1) return 0
        var minDiff = abs(inOrder[1] - inOrder[0])
        for (i in 1 until inOrder.size) {
            minDiff = min(minDiff, abs(inOrder[i] - inOrder[i - 1]))
        }
        return minDiff
    }

    private fun inOrder(root: TreeNode?, list: MutableList<Int>) {
        if (root == null) return
        inOrder(root.left, list)
        list.add(root.`val`)
        inOrder(root.right, list)
    }
}