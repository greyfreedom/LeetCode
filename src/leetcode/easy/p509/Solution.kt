package src.leetcode.easy.p509

class Solution {
    fun fib(n: Int): Int {
        if (n < 2) return n
        var dp = IntArray(n + 1)
        dp[0] = 0
        dp[1] = 1
        for (i in 2..n) {
            dp[i] = dp[i - 1] + dp[i - 2]
        }
        return dp[n]
    }
}