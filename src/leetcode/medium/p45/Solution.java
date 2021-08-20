package src.leetcode.medium.p45;

class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 1;
        int cur = 0;
        int next = 0;
        int step = 1;
        for (int i = 0; i <= cur; i++) {
            next = Math.max(next, nums[i] + i);
            if (i == cur) {
                if (next < nums.length - 1) {
                    step++;
                    cur = next;
                } else {
                    return step;
                }
            }
        }
        return step;
    }
}
