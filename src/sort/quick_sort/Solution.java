package src.sort.quick_sort;

import java.util.Arrays;

public class Solution {
    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int low = left;
            int high = right;
            int target = nums[left];
            while (low < high) {
                while (low < high && target <= nums[high]) {
                    high--;
                }
                nums[low] = nums[high];
                while (low < high && target >= nums[low]) {
                    low++;
                }
                nums[high] = nums[low];
            }
            nums[low] = target;
            quickSort(nums, left, low - 1);
            quickSort(nums, low + 1, right);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {22, 1, 1, 56, 2, 10, 0, 12, 3, 67, 4, 56, 54};
        solution.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
