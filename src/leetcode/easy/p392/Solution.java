package src.leetcode.easy.p392;

class Solution {
    public boolean isSubsequence(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        if (lenS == 0 && lenT == 0) return true;
        if (lenS == 0) return true;
        if (lenT == 0) return false;
        if (lenS > lenT) return false;
        int[][] dp = new int[lenS][lenT];
        boolean found = false;
        for (int i = 0; i < lenS; i++) {
            if (s.charAt(i) == t.charAt(0) || found) {
                dp[i][0] = 1;
                found = true;
            }
        }
        found = false;
        for (int i = 0; i < lenT; i++) {
            if (t.charAt(i) == s.charAt(0) || found) {
                dp[0][i] = 1;
                found = true;
            }
        }
        for (int i = 1; i < lenS; i++) {
            for (int j = 1; j < lenT; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[lenS - 1][lenT - 1] == s.length();
    }
}
