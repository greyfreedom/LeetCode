package src.leetcode.medium.p54;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int max = matrix.length * matrix[0].length;
        int count = 1;
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        List<Integer> res = new ArrayList<>();
        while (count <= max) {
            for (int i = left; i <= right && count <= max; i++) {
                res.add(matrix[top][i]);
                count++;
            }
            top++;
            for (int i = top; i <= bottom && count <= max; i++) {
                res.add(matrix[i][right]);
                count++;
            }
            right--;
            for (int i = right; i >= left && count <= max; i--) {
                res.add(matrix[bottom][i]);
                count++;
            }
            bottom--;
            for (int i = bottom; i >= top && count <= max; i--) {
                res.add(matrix[i][left]);
                count++;
            }
            left++;
        }
        return res;
    }
}