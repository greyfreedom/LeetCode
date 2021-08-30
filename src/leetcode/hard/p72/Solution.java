package src.leetcode.hard.p72;

class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 == 0 && len2 == 0) return 0;
        if (len1 == 0) return len2;
        if (len2 == 0) return len1;
        // dp[i][j] i结尾的字符串 与j结尾的字符串 相等时 最小编辑距离
        int[][] dp = new int[len1][len2];
        boolean found = false;
        for (int i = 0; i < len1; i++) {
            if (word1.charAt(i) == word2.charAt(0)) {
                found = true;
            }
            dp[i][0] = found ? i : i + 1;
        }
        found = false;
        for (int i = 0; i < len2; i++) {
            if (word2.charAt(i) == word1.charAt(0)) {
                found = true;
            }
            dp[0][i] = found ? i : i + 1;
        }
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }
        return dp[len1 - 1][len2 - 1];
    }
}
