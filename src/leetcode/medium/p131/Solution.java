package src.leetcode.medium.p131;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> path = new ArrayList<>();
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backTrack(s, 0);
        return res;
    }

    private void backTrack(String s, int start) {
        if (start >= s.length()) {
            if (!path.isEmpty()) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        int len = s.length();
        for (int i = start; i < len; i++) {
            if (isPartition(s, start, i)) {
                String sub = s.substring(start, i + 1);
                path.add(sub);
                backTrack(s, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPartition(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
