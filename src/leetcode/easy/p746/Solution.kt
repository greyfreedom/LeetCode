package src.leetcode.easy.p746

import kotlin.math.min

class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val dp = IntArray(cost.size + 1)
        dp[0] = 0
        dp[1] = 0
        for (i in 2..cost.size) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2])
        }
        return dp[cost.size]
    }
}