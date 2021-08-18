package src.leetcode.medium.p216

class Solution {
    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        val path = arrayListOf<Int>()
        val res = arrayListOf<List<Int>>()
        backTrack(k, n, 1, 0, path, res)
        return res
    }

    private fun backTrack(k: Int, n: Int, startIndex: Int, sum: Int, path: ArrayList<Int>, res: ArrayList<List<Int>>) {
        if (path.size == k) {
            if (sum == n) {
                res.add(ArrayList(path))
            }
            return
        }
        if (sum >= n) return
        for (i in startIndex..(9 - k + path.size + 1)) {
            path.add(i)
            backTrack(k, n, i + 1, sum + i, path, res)
            path.remove(i)
        }
    }
}