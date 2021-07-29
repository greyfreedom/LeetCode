package src.leetcode.medium.p59;


class Solution {
    public int[][] generateMatrix(int n) {
        int max = n * n;
        int count = 1;
        int[][] res = new int[n][n];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int direction = 0;
        int row = 0, col = 0;
        while (count <= max) {
            res[row][col] = count;
            int nextRow = row + directions[direction][0];
            int nextCol = col + directions[direction][1];
            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || res[nextRow][nextCol] != 0) {
                direction = (direction + 1) % 4;
            }
            row = row + directions[direction][0];
            col = col + directions[direction][1];
            count++;
        }
        return res;
    }
}
