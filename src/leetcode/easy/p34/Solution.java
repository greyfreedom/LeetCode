package src.leetcode.easy.p34;

import java.util.Arrays;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int rangeLeft = binarySearchBorder(nums, target, true);
        if (rangeLeft == -1) {
            return new int[]{-1, -1};
        }
        int rangeRight = binarySearchBorder(nums, target, false);
        return new int[]{rangeLeft, rangeRight};
    }

    private int binarySearchBorder(int[] nums, int target, boolean isLeft) {
        int left = 0, right = nums.length - 1;
        int border = -1;
        while (left <= right) {
            int middle = ((right - left) >> 1) + left;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                border = middle;
                if (isLeft) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
        }
        return border;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 8)));
    }
}
