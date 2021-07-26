package src.leetcode.easy.p283;

import java.util.Arrays;

class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int slow = 0;
        for (int fast = 0; fast < len; fast++) {
            if (nums[fast] != 0) {
                int tmp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = tmp;
                slow++;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{0, 1, 0, 3, 12};
        solution.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}
