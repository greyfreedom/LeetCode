package src.leetcode.medium.p491;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backTrack(nums, 0);
        return res;
    }

    private void backTrack(int[] nums, int start) {
        if (path.size() >= 2) {
            res.add(new ArrayList<>(path));
        }
        if (start >= nums.length) return;
        boolean[] used = new boolean[201];
        for (int i = start; i < nums.length; i++) {
            if ((!path.isEmpty() && path.get(path.size() - 1) > nums[i]) || (used[nums[i] + 100])) {
                continue;
            }
            used[nums[i] + 100] = true;
            path.add(nums[i]);
            backTrack(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
