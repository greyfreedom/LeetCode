package src.leetcode.hard.p37;

class Solution {
    public void solveSudoku(char[][] board) {
        backTrack(board);
    }

    private boolean backTrack(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] != '.') continue;
                for (char k = '1'; k <= '9'; k++) {
                    if (isValid(board, i, j, k)) {
                        board[i][j] = k;
                        if (backTrack(board)) return true;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char k) {
        int rowLen = board.length;
        int colLen = board[0].length;
        // 检查行
        for (int j = 0; j < colLen; j++) {
            if (board[row][j] == k) return false;
        }
        // 检查列
        for (int i = 0; i < rowLen; i++) {
            if (board[i][col] == k) return false;
        }
        // 检查当前单元
        int rowStart = (row / 3) * 3;
        int colStart = (col / 3) * 3;
        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (board[i][j] == k) return false;
            }
        }
        return true;
    }
}
