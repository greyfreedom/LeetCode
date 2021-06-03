package src.leetcode.easy.p53;

class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(nums[i], (nums[i] + pre));
            if (max < pre) {
                max = pre;
            }
        }
        return max;
    }
}
