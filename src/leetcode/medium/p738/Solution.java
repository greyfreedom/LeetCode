package src.leetcode.medium.p738;


class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] number = String.valueOf(n).toCharArray();
        int start = number.length;
        for (int i = number.length - 1; i > 0; i--) {
            if (number[i] < number[i - 1]) {
                start = i;
                number[i - 1] = (char) (number[i - 1] - 1);
            }
        }
        for (int i = start; i < number.length; i++) {
            number[i] = '9';
        }
        return Integer.parseInt(String.valueOf(number));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.monotoneIncreasingDigits(9));
        System.out.println(solution.monotoneIncreasingDigits(10));
        System.out.println(solution.monotoneIncreasingDigits(1234));
        System.out.println(solution.monotoneIncreasingDigits(4123));
        System.out.println(solution.monotoneIncreasingDigits(4321));
        System.out.println(solution.monotoneIncreasingDigits(332));
    }
}
