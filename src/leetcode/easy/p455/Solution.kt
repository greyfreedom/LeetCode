package src.leetcode.easy.p455

import java.util.*

//[10,9,8,7]
//[5,6,7,8]
class Solution {
    fun findContentChildren(g: IntArray, s: IntArray): Int {
        var count = 0
        Arrays.sort(g)
        Arrays.sort(s)
        var childIndex = 0
        for (cook in s) {
            if (childIndex >= g.size) break
            if (cook >= g[childIndex]) {
                count++
                childIndex++
            }
        }
        return count
    }
}