package src.jianzhioffer.p58;

//abcdefg 2
class Solution {
    public String reverseLeftWords(String s, int n) {
        char[] str = s.toCharArray();
        reverse(str, 0, n - 1);
        reverse(str, n, str.length - 1);
        reverse(str, 0, str.length - 1);
        return new String(str);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
