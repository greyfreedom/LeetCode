package src.leetcode.medium.p376

class Solution {
    fun wiggleMaxLength(nums: IntArray): Int {
        var result = 1
        if (nums.size > 1) {
            var curDiff: Int
            var preDiff = 0
            for (i in 0..nums.size - 2) {
                curDiff = nums[i + 1] - nums[i]
                if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                    result++
                    preDiff = curDiff
                }
            }
        }
        return result
    }
}