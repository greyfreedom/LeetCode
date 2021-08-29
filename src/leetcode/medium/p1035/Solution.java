package src.leetcode.medium.p1035;

// [3,2]
// [2,2,2,3]
class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        boolean find = false;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == nums2[0] || find) {
                dp[i][0] = 1;
                find = true;
            }
        }
        find = false;
        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] == nums1[0] || find) {
                dp[0][i] = 1;
                find = true;
            }
        }
        for (int i = 1; i < nums1.length; i++) {
            for (int j = 1; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[nums1.length - 1][nums2.length - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxUncrossedLines(new int[]{3, 2}, new int[]{2, 2, 2, 3}));
    }
}
