package src.leetcode.medium.p654;

import src.common.TreeNode;

// [3,2,1,6,0,5]
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int start, int end) {
        if (nums == null) {
            return null;
        }
        if (start > end) return null;
        int index = start;
        int max = nums[index];
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = build(nums, start, index - 1);
        node.right = build(nums, index + 1, end);
        return node;
    }
}
