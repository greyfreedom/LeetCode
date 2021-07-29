package src.leetcode.hard.p76;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// ADOBECODEBANC  ABC
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> counter = new HashMap<>();
        HashMap<Character, Integer> ori = new HashMap<>();
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            ori.put(t.charAt(i), ori.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0, res = Integer.MAX_VALUE;
        int sLen = s.length();
        int resLeft = -1, resRight = -1;
        for (int right = 0; right < sLen; right++) {
            if (ori.containsKey(s.charAt(right))) {
                counter.put(s.charAt(right), counter.getOrDefault(s.charAt(right), 0) + 1);
            }
            while (check(counter, ori)) {
                if (right - left + 1 < res) {
                    res = right - left + 1;
                    resLeft = left;
                    resRight = left + res;
                }
                if (counter.containsKey(s.charAt(left))) {
                    counter.put(s.charAt(left), counter.get(s.charAt(left)) - 1);
                }
                left++;
            }
        }
        if (resLeft >= 0 && resRight >= 0) {
            return s.substring(resLeft, resRight);
        } else {
            return "";
        }
    }

    private boolean check(HashMap<Character, Integer> counter, HashMap<Character, Integer> ori) {
        Set<Map.Entry<Character, Integer>> entrySet = ori.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            char key = entry.getKey();
            int value = entry.getValue();
            if (counter.getOrDefault(key, 0) < value) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minWindow("a", "a"));
    }
}
