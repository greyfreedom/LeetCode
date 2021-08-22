package src.leetcode.easy.p1005;

import java.util.Arrays;

class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (k > 0 && nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
            }
            min = Math.min(min, nums[i]);
            sum += nums[i];
        }
        if (k % 2 == 1) {
            return sum - 2 * min;
        } else {
            return sum;
        }
    }
}
