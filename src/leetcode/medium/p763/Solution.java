package src.leetcode.medium.p763;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// ababcbacadefegdehijhklij
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] border = new int[26];
        Arrays.fill(border, -1);
        int len = s.length();
        for (int i = 0; i < len; i++) {
            border[s.charAt(i) - 'a'] = i;
        }
        int left = 0;
        int right = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            char target = s.charAt(i);
            int targetBorder = border[target - 'a'];
            right = Math.max(right, targetBorder);
            if (i == right) {
                res.add(right - left + 1);
                left = i + 1;
            }
        }
        return res;
    }
}
