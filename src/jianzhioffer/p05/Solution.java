package src.jianzhioffer.p05;

class Solution {
    public String replaceSpace(String s) {
        if (s == null || s.length() <= 0) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') {
                builder.append("%20");
            } else {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }
}