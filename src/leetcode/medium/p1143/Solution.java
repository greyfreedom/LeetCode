package src.leetcode.medium.p1143;

// "abcde"
// "ace"
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        int len1 = text1.length();
        int res = 0;
        boolean find = false;
        for (int i = 0; i < len1; i++) {
            if (text1.charAt(i) == text2.charAt(0) || find) {
                dp[i][0] = 1;
                res = 1;
                find = true;
            }
        }
        find = false;
        int len2 = text2.length();
        for (int i = 0; i < len2; i++) {
            if (text2.charAt(i) == text1.charAt(0) || find) {
                dp[0][i] = 1;
                res = 1;
                find = true;
            }
        }
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                if (res < dp[i][j]) res = dp[i][j];
            }
        }
        return res;
    }
}