package src.leetcode.easy.p674;

import java.util.Arrays;

// [1,3,5,4,2,3,4,5]
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            if (res < dp[i]) res = dp[i];
        }
        return res;
    }
}
