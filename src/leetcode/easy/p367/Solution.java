package src.leetcode.easy.p367;

class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 0, right = num;
        while (left <= right) {
            int middle = ((right - left) >> 1) + left;
            long res = (long) middle * middle;
            if (res < num) {
                left = middle + 1;
            } else if (res > num) {
                right = middle - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
