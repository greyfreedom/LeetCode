package src.leetcode.easy.p459;

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int[] next = getNext(s);
        int len = s.length();
        if (next[len - 1] != 0 && (len % (len - next[len - 1]) == 0)) {
            return true;
        }
        return false;
    }

    private int[] getNext(String s) {
        int len = s.length();
        int[] next = new int[len];
        int j = 0;
        next[0] = j;
        for (int i = 1; i < len; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
