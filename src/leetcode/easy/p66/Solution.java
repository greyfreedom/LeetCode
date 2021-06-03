package src.leetcode.easy.p66;

class Solution {
    public int[] plusOne(int[] digits) {
        boolean allNine = true;
        int len = digits.length;
        for (int i = 0; i < len; i++) {
            if (digits[i] != 9) {
                allNine = false;
                break;
            }
        }
        int resLen = allNine ? len + 1 : len;
        int[] res = new int[resLen];
        int carry = 1;
        int originIndex = len - 1;
        int resIndex = resLen - 1;
        while (resIndex >= 0) {
            int origin = originIndex >=0 ? digits[originIndex] : 0;
            int tmp = origin + carry;
            res[resIndex] = tmp % 10;
            carry = tmp / 10;
            resIndex--;
            originIndex--;
        }
        return res;
    }
}
