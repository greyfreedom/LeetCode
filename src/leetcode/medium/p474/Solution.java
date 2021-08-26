package src.leetcode.medium.p474;

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // dp[j][k] 表示 最多有 j 个 0 和 k 个 1 的子集的个数
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (int i = 0; i < strs.length; i++) {
            int numOfZero = 0, numOfOne = 0;
            for (int k = 0; k < strs[i].length(); k++) {
                if (strs[i].charAt(k) == '0') {
                    numOfZero++;
                } else {
                    numOfOne++;
                }
            }

            for (int j = m; j >= numOfZero; j--) {
                for (int k = n; k >= numOfOne; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - numOfZero][k - numOfOne] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
