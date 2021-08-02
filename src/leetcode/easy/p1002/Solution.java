package src.leetcode.easy.p1002;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> commonChars(String[] words) {
        int[] record = new int[26];
        int[] record2 = new int[26];
        int len = words[0].length();
        for (int i = 0; i < len; i++) {
            record[words[0].charAt(i) - 'a']++;
        }
        len = words.length;
        for (int i = 1; i < len; i++) {
            String str = words[i];
            int len2 = str.length();
            Arrays.fill(record2, 0);
            for (int j = 0; j < len2; j++) {
                record2[str.charAt(j) - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                record[j] = Math.min(record[j], record2[j]);
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (record[i] > 0) {
                res.add(String.valueOf((char) (i + 'a')));
                record[i]--;
            }
        }
        return res;
    }
}
