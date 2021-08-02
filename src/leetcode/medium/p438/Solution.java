package src.leetcode.medium.p438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// cbaebabacd abc
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        List<Integer> res = new ArrayList<>();
        if (lenS < lenP) {
            return res;
        }
        int[] recordS = new int[26];
        int[] recordP = new int[26];
        for (int i = 0; i< lenP; i++) {
            recordS[s.charAt(i) - 'a']++;
            recordP[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(recordS, recordP)) {
            res.add(0);
        }
        for (int i = lenP; i < lenS; i++) {
            recordS[s.charAt(i - lenP) - 'a']--;
            recordS[s.charAt(i) - 'a']++;
            if (Arrays.equals(recordS, recordP)) {
                res.add(i - lenP + 1);
            }
        }
        return res;
    }
}
