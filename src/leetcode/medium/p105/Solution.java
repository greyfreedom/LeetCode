package src.leetcode.medium.p105;

import src.common.TreeNode;

// preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (preorder == null || preorder.length <= 0) return null;
        if (pStart > pEnd || iStart > iEnd) return null;
        int nodeVal = preorder[pStart];
        TreeNode node = new TreeNode(nodeVal);
        int inOrderIndex = 0;
        for (int i = iStart; i <= iEnd; i++) {
            if (inorder[i] == nodeVal) {
                inOrderIndex = i;
                break;
            }
        }
        int leftSize = inOrderIndex - iStart;
        node.left = build(preorder, pStart + 1, pStart + leftSize, inorder, iStart, inOrderIndex - 1);
        node.right = build(preorder, pStart + leftSize + 1, pEnd, inorder, inOrderIndex + 1, iEnd);
        return node;
    }
}
