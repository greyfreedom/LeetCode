package src.leetcode.easy.p541;

// a,b,c,d,e
class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i = i + 2 * k) {
            int start = i;
            int end = Math.min(chars.length - 1, start + k - 1);
            while (start < end) {
                char tmp = chars[start];
                chars[start] = chars[end];
                chars[end] = tmp;
                start++;
                end--;
            }
        }
        return new String(chars);
    }
}
