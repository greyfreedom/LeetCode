package src.leetcode.easy.p9;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int total = 0;
        int target = x;
        while (target != 0) {
            int tmp = target % 10;
            target /= 10;
            total = total * 10 + tmp;
        }
        return total == x;
    }
}
