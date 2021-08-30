package src.leetcode.hard.p115;

class Solution {
    public int numDistinct(String s, String t) {
        int lens = s.length();
        int lent = t.length();
        if (lens == 0 && lent == 0) return 1;
        if (lens == 0) return 0;
        if (lent == 0) return 1;
        int[][] dp = new int[lens][lent];
        int count = 0;
        for (int i = 0; i < lens; i++) {
            if (s.charAt(i) == t.charAt(0)) {
                count++;
            }
            dp[i][0] = count;
        }
        for (int i = 1; i < lens; i++) {
            for (int j = 1; j < lent; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[lens - 1][lent - 1];
    }
}
