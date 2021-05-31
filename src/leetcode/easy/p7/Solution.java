package src.leetcode.easy.p7;

class Solution {
    /**
     * 思路：翻转数字的话，可以从低位开始，用取余取到低位，然后与之前的结果乘以10后的数字相加
     * 此处注意的是可能会溢出，因为题目中提到不允许使用64位的整数存储，因此不能使用long类型
     * 这里采取的防止溢出的方式是：当累计结果大于（小于） 最大值（最小值）的十分之一时说明下一次的结果会溢出
     * 当累计结果等于 最大值（最小值）的十分之一且当前取到的低位数值大于（小于）最大值（最小值）的最低位数值时，下一次结果会溢出
     */
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int tmp = x % 10;
            x = x / 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && tmp > Integer.MAX_VALUE % 10)) {
                return 0;
            } else if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && tmp < Integer.MIN_VALUE % 10)) {
                return 0;
            }
            res = res * 10 + tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(0));
        System.out.println(solution.reverse(1));
        System.out.println(solution.reverse(123));
        System.out.println(solution.reverse(8238087));
        System.out.println(solution.reverse(1001000));
        System.out.println(solution.reverse(0x7fffffff)); // Integer.MAX_VALUE
        System.out.println(solution.reverse(0x80000000)); // Integer.MIN_VALUE
    }
}
