package src;

import sun.awt.geom.AreaOp;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int strStr(String haystack, String needle) {
        Deque<String> stack = new LinkedList<>();
        stack.addLast(null);
        return 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("", ""));
    }

    public void slideWindow(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                int curLen = right - left + 1;
                res = Math.min(res, curLen);
                sum -= nums[left];
                left++;
            }
        }
    }

    public int kmp(String origin, String pattern) {
        int lenO = origin.length();
        int lenP = pattern.length();
        if (lenP == 0) return 0;
        int[] next = getNext(pattern);
        int j = 0;
        for (int i = 0; i < lenO; i++) {
            while (j > 0 && origin.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }
            if (origin.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if (j == pattern.length()) {
                return i - lenP + 1;
            }
        }
        return -1;
    }

    private int[] getNext(String pattern) {
        int[] next = new int[pattern.length()];
        int j = 0;
        next[0] = j;
        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
