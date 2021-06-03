package src.leetcode.easy.p35;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1, res = nums.length;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (nums[mid] == target) {
                res = mid;
                break;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                res = mid;
                right = mid - 1;
            }
        }
        return res;
    }
}