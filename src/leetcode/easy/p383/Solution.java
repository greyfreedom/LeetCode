package src.leetcode.easy.p383;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null) {
            return true;
        }
        if (magazine == null) {
            return false;
        }
        int[] record = new int[26];
        int lenM = magazine.length();
        int lenR = ransomNote.length();
        for (int i = 0; i < lenM; i++) {
            record[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < lenR; i++) {
            record[ransomNote.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (record[i] < 0) {
                return false;
            }
        }
        return true;
    }
}
