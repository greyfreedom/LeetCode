package src.leetcode.medium.p494;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int item : nums) {
            sum += item;
        }
        if ((sum + target) % 2 != 0) return 0;
        int a = (sum + target) / 2;
        if (a < 0) return 0;
        int[] dp = new int[a + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = a; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[a];
    }
}
