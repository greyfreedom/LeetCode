package src.leetcode.medium.p90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTrack(nums, 0);
        return res;
    }

    private void backTrack(int[] nums, int start) {
        res.add(new ArrayList<>(path));
        if (start >= nums.length) return;
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            backTrack(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
