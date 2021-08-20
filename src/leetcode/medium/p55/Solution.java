package src.leetcode.medium.p55;

class Solution {
    public boolean canJump2(int[] nums) {
        if (nums.length <= 1) return true;
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover, nums[i] + i);
            if (cover >= nums.length - 1) return true;
        }
        return false;
    }

    public boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;
        int need = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < need) {
                need++;
            } else {
                need = 1;
            }
        }
        return nums[0] >= need;
    }
}
