package src.leetcode.medium.p454;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        if (nums1 == null || nums1.length <= 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap();
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int temp = nums1[i] + nums2[j];
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int temp = nums3[i] + nums4[j];
                if (map.containsKey(0 - temp)) {
                    res+= map.get(0 - temp);
                }
            }
        }
        return res;
    }
}
