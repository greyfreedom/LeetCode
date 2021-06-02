package src.leetcode.medium.p11;

class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int current = Math.min(height[left], height[right]) * (right - left);
            if (max < current) {
                max = current;
            }
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }
}