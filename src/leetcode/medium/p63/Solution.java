package src.leetcode.medium.p63;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        boolean crash = false;
        for (int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] == 1 || crash) {
                dp[i][0] = 0;
                crash = true;
            } else {
                dp[i][0] = 1;
            }
        }
        crash = false;
        for (int i = 0; i < col; i++) {
            if (obstacleGrid[0][i] == 1 || crash) {
                dp[0][i] = 0;
                crash = true;
            } else {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[row - 1][col - 1];
    }
}
