package src.leetcode.medium.p46

class Solution {
    private val path = arrayListOf<Int>()
    private val res = arrayListOf<List<Int>>()

    fun permute(nums: IntArray): List<List<Int>> {
        backTrack(nums, BooleanArray(nums.size))
        return res
    }

    private fun backTrack(nums: IntArray, used: BooleanArray) {
        if (path.size == nums.size) {
            res.add(ArrayList(path))
            return
        }
        for (i in 0 until nums.size) {
            if (!used[i]) {
                path.add(nums[i])
                used[i] = true
                backTrack(nums, used)
                used[i] = false
                path.removeAt(path.size - 1)
            }
        }
    }
}