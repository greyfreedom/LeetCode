package src.leetcode.medium.p583;

class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 == 0 && len2 == 0) return 0;
        if (len1 == 0) return len2;
        if (len2 == 0) return len1;
        int[][] dp = new int[len1][len2];
        boolean found = false;
        for (int i = 0; i < len1; i++) {
            if (word1.charAt(i) == word2.charAt(0)) {
                found = true;
            }
            if (found) {
                dp[i][0] = i;
            } else {
                dp[i][0] = i + 2;
            }
        }
        found = false;
        for (int j = 0; j < len2; j++) {
            if (word2.charAt(j) == word1.charAt(0)) {
                found = true;
            }
            if (found) {
                dp[0][j] = j;
            } else {
                dp[0][j] = j + 2;
            }
        }
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 2, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }
        return dp[len1 - 1][len2 - 1];
    }
}
