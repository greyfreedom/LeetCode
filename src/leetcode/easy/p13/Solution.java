package src.leetcode.easy.p13;

class Solution {
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int index = 0;
        int total = 0;
        while (index < len) {
            if (index + 1 >= len) {
                char target = chars[index];
                total += getNumber(target);
                index += 1;
            } else {
                int tryD = tryDouble(chars[index], chars[index + 1]);
                if (tryD > 0) {
                    total += tryD;
                    index += 2;
                } else {
                    total += getNumber(chars[index]);
                    index += 1;
                }
            }
        }
        return total;
    }

    private int getNumber(char target) {
        if (target == 'I') {
            return 1;
        } else if (target == 'V') {
            return 5;
        } else if (target == 'X') {
            return 10;
        } else if (target == 'L') {
            return 50;
        } else if (target == 'C') {
            return 100;
        } else if (target == 'D') {
            return 500;
        } else {
            return 1000;
        }
    }

    private int tryDouble(char l, char r) {
        if (l == 'I' && r == 'V') {
            return 4;
        } else if (l == 'I' && r == 'X') {
            return 9;
        } else if (l == 'X' && r == 'L') {
            return 40;
        } else if (l == 'X' && r == 'C') {
            return 90;
        } else if (l == 'C' && r == 'D') {
            return 400;
        } else if (l == 'C' && r == 'M') {
            return 900;
        } else {
            return 0;
        }
    }
}
