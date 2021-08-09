package src.leetcode.medium.p151;

class Solution {
    public String reverseWords(String s) {
        // 去掉空格
        StringBuilder sb = removeSpace(s);
        // 翻转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        // 翻转单词
        reverseWord(sb);
        return sb.toString();
    }

    private StringBuilder removeSpace(String s) {
        int len = s.length();
        int start = 0;
        int end = len - 1;
        while (start < len && s.charAt(start) == ' ') start++;
        while (end >= 0 && s.charAt(end) == ' ') end--;
        StringBuilder builder = new StringBuilder();
        if (end < start) return builder;
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            if (c != ' ' || s.charAt(i + 1) != ' ') {
                builder.append(c);
            }
        }
        return builder;
    }

    private void reverseString(StringBuilder builder, int start, int end) {
        int left = start;
        int right = end;
        while (left < right) {
            char tmp = builder.charAt(left);
            builder.setCharAt(left, builder.charAt(right));
            builder.setCharAt(right, tmp);
            left++;
            right--;
        }
    }

    private void reverseWord(StringBuilder builder) {
        int start = 0;
        int end = 1;
        int len = builder.length();
        while (start < len) {
            while (end < len) {
                if (builder.charAt(end) == ' ') {
                    break;
                }
                end++;
            }
            reverseString(builder, start, end - 1);
            start = end +1;
            end = start +1;
        }
    }
}
