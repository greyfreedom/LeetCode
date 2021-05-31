package src.leetcode.easy.p342;

class Solution {

    /**
     * 思路：因为4的x次幂 >= 0，因此先排除负数。4的x次幂 = 2的2x次幂，因此只需要判断是2的n次幂，且n是偶数即可
     */
    public boolean isPowerOfFour1(int n) {
        if (n <= 0) return false; // 排除负数
        int index = -1;
        // 我这里用遍历查看是否只存在一位是1来判断是否是2的次幂
        for (int i = 0; i < 31; i++) {
            if ((n & 0x00000001) == 1) {
                if (index >= 0) {
                    return false;
                }
                index = i;
            }
            n = n >> 1;
        }
        return index % 2 == 0;
    }

    /**
     * 思路：因为4的x次幂 >= 0，因此先排除负数。4的x次幂 = 2的2x次幂，
     * 因此可以先判断n是否是2的次幂：((n & (n - 1)) == 0
     * 2的2x次幂中，有且仅有一位1，且这个1在低位开始的偶数次幂位置上，也就是
     * 用 1010 1010 1010 1010 1010 1010 1010 1010 与 n 相与 结果为 0
     */
    public boolean isPowerOfFour(int n) {
        return n > 0 && (((n & (n - 1)) == 0) && ((n & 0xaaaaaaaa) == 0));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfFour(-2147483647));
//        System.out.println(solution.isPowerOfFour(0));
//        System.out.println(solution.isPowerOfFour(1));
//        System.out.println(solution.isPowerOfFour(2));
//        System.out.println(solution.isPowerOfFour(3));
//        System.out.println(solution.isPowerOfFour(4));
//        System.out.println(solution.isPowerOfFour(17));
//        System.out.println(solution.isPowerOfFour(5));
//        System.out.println(Integer.toBinaryString(-2147483647));

    }
}
