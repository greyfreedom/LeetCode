package src.leetcode.easy.p1;

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // target - x = y ，当遍历到x时，查看x是否在map中
        // 如果不在，将y作为key，x的下标i作为value放入map中，意思为下标为i的数需要y来组成target
        // 如果存在，说明之前的操作中有一个数可以和我组成target，那么其下标就是我对应的value
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            } else {
                map.put(target - nums[i], i);
            }
        }
        return new int[]{};
    }
}
