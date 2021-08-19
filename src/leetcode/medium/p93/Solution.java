package src.leetcode.medium.p93;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> path = new ArrayList<>();
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backTrack(s, 0);
        return res;
    }

    private void backTrack(String s, int start) {
        int len = s.length();
        if (path.size() == 4) {
            if (start >= len) {
                StringBuilder builder = new StringBuilder();
                builder.append(path.get(0)).append(".")
                        .append(path.get(1)).append(".")
                        .append(path.get(2)).append(".")
                        .append(path.get(3));
                res.add(builder.toString());
            }
            return;
        }
        if (start >= len) {
            return;
        }

        for (int i = start; i < len; i++) {
            if (isValid(s, start, i)) {
                String sub = s.substring(start, i + 1);
                path.add(sub);
                backTrack(s, i + 1);
                path.remove(path.size() - 1);
            } else {
                return;
            }
        }
    }

    private boolean isValid(String s, int start, int end) {
        if (start > end) return false;
        if (s.charAt(start) == '0' && start != end) return false;
        int sum = 0;
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') return false;
            sum = sum * 10 + (c - '0');
        }
        return sum <= 255;
    }
}
