package src.leetcode.medium.p49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> result = new HashMap<>();
        int len = strs.length;
        for (int i = 0; i < len; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            List<String> list = result.getOrDefault(s, new ArrayList<String>());
            list.add(strs[i]);
            result.put(s, list);
        }
        return new ArrayList<>(result.values());
    }
}