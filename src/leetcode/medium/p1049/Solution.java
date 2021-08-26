package src.leetcode.medium.p1049;

class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int item : stones) {
            sum += item;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - dp[target] - dp[target];
    }
}
