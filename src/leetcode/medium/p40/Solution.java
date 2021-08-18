package src.leetcode.medium.p40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//[10,1,2,7,6,1,5]
// 1,1,2,5,6,7,10
// 8
class Solution {
    private final List<Integer> path = new ArrayList<>();
    private final List<List<Integer>> res = new ArrayList<>();


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(candidates, target, 0, 0, new boolean[candidates.length]);
        return res;
    }

    private void backTrack(int[] candidates, int target, int index, int sum, boolean[] using) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = index; i < candidates.length && sum + candidates[i] <= target; i++) {
            // 这里也可以使用 if (i > index && candidates[i] == candidates[i - 1])，这样就可以不使用using数组了
            if (i > 0 && candidates[i] == candidates[i - 1] && !using[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            using[i] = true;
            backTrack(candidates, target, i + 1, sum + candidates[i], using);
            using[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
