package src.leetcode.easy.p88;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 = m - 1, i2 = n - 1, j = m + n - 1;
        while (j >= 0) {
            int cur;
            if (i1 < 0) {
                cur = nums2[i2];
                i2--;
            } else if (i2 < 0) {
                cur = nums1[i1];
                i1--;
            } else if (nums1[i1] <= nums2[i2]) {
                cur = nums2[i2];
                i2--;
            } else {
                cur = nums1[i1];
                i1--;
            }
            nums1[j] = cur;
            j--;
        }
    }
}
