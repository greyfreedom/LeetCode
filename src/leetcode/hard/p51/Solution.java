package src.leetcode.hard.p51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] pan = new char[n][n];
        for (char[] chars : pan) {
            Arrays.fill(chars, '.');
        }
        backTrack(pan, 0, n);
        return res;
    }

    private void backTrack(char[][] pan, int row, int n) {
        if (row >= n) {
            // 收集数据
            res.add(getResolve(pan));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(pan, row, col, n)) {
                pan[row][col] = 'Q';
                backTrack(pan, row + 1, n);
                pan[row][col] = '.';
            }
        }
    }

    private boolean isValid(char[][] pan, int row, int col, int n) {
        // 无需检查行，因为当前遍历过程中，一行只会有一个Q，就是我们目前想要放的位置
        // 检查列
        for (int i = 0; i < row; i++) {
            if (pan[i][col] == 'Q') return false;
        }
        // 检查45度对角线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (pan[i][j] == 'Q') return false;
        }
        // 检查135度对角线
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (pan[i][j] == 'Q') return false;
        }
        return true;
    }

    private List<String> getResolve(char[][] pan) {
        List<String> resolve = new ArrayList<>();
        for (char[] row : pan) {
            resolve.add(String.valueOf(row));
        }
        return resolve;
    }
}
