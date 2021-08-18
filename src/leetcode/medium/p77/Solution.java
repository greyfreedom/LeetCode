package src.leetcode.medium.p77;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(n, k, 1, new ArrayList<Integer>(), res);
        return res;
    }

    private void backTrack(int n, int k, int startIndex, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backTrack(n, k, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }
}
