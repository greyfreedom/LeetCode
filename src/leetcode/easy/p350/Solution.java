package src.leetcode.easy.p350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            int target = nums2[i];
            if (map.containsKey(target)) {
                int count = map.get(target);
                if (count > 0) {
                    resList.add(target);
                    map.put(target, count - 1);
                }
            }
        }
        int size = resList.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = resList.get(i);
        }
        return result;
    }
}
