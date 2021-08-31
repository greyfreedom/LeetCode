package src.leetcode.medium.p647;

import java.util.Arrays;

class Solution {
    public int countSubstrings2(String s) {
        if (s == null || s.length() <= 0) return 0;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], false);
        }
        int res = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 2) {
                        dp[i][j] = true;
                        res++;
                    } else if (dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        res++;
                    }
                }
            }
        }
        return res;
    }

    public int countSubstrings(String s) {
        if (s == null || s.length() <= 0) return 0;
        int len = s.length();
        int res = 0;
        for (int i = 0; i < len; i++) {
            res += find(s, i, i);
            res += find(s, i, i + 1);
        }
        return res;
    }

    private int find(String s, int start, int end) {
        int res = 0;
        int len = s.length();
        while (start >= 0 && end < len && (s.charAt(start) == s.charAt(end))) {
            res++;
            start--;
            end++;
        }
        return res;
    }
}
