package src.leetcode.easy.p69;

class Solution {
    public int mySqrt(int x) {
        int left = 0, right = x;
        int target = -1;
        while (left <= right) {
            int middle = ((right - left) >> 1) + left;
            if ((long) middle * middle <= x) {
                target = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return target;
    }
}