package src.leetcode.easy.p242;

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        int lenS = s.length();
        int lenT = t.length();
        for (int i = 0; i < lenS; i++) {
            record[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < lenT; i++) {
            record[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (record[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
