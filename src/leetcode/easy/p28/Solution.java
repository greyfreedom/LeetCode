package src.leetcode.easy.p28;

// aabaabaaf aabaaf
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        int[] next = getNext(needle);
        int j = 0;
        int lenOfH = haystack.length();
        int lenOfN = needle.length();
        for (int i = 0; i < lenOfH; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == lenOfN) {
                return i - lenOfN + 1;
            }
        }
        return -1;
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
