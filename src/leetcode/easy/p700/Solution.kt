package src.leetcode.easy.p700

import src.common.TreeNode

class Solution {
    fun searchBST2(root: TreeNode?, `val`: Int): TreeNode? {
        return if (root == null || root.`val` == `val`) {
            root
        } else if (root.`val` > `val`) {
            searchBST2(root.left, `val`)
        } else if (root.`val` < `val`) {
            searchBST2(root.right, `val`)
        } else {
            null
        }
    }

    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        var node = root
        while (node != null) {
            node = when {
                node.`val` == `val` -> {
                    return node
                }
                node.`val` > `val` -> {
                    node.left
                }
                else -> {
                    node.right
                }
            }
        }
        return null
    }
}