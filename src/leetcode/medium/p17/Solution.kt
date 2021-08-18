package src.leetcode.medium.p17

import com.sun.xml.internal.fastinfoset.util.StringArray
import java.lang.StringBuilder

// 657
class Solution {
    fun letterCombinations(digits: String): List<String> {
        val path = StringBuilder()
        val res = arrayListOf<String>()
        backTrack(digits.length, digits, 0, path, res)
        return res
    }

    private fun backTrack(k: Int, digits: String, index: Int, path: StringBuilder, res: ArrayList<String>) {
        if (path.length == k) {
            res.add(path.toString())
            return
        }
        val array = getChars(digits[index])
        for (item in array) {
            path.append(item)
            backTrack(k, digits, index + 1, path, res)
            path.deleteCharAt(path.length - 1)
        }
    }

    private fun getChars(c: Char): Array<String> {
        return when (c) {
            '2' -> arrayOf("a", "b", "c")
            '3' -> arrayOf("d", "e", "f")
            '4' -> arrayOf("g", "h", "i")
            '5' -> arrayOf("j", "k", "l")
            '6' -> arrayOf("m", "n", "o")
            '7' -> arrayOf("p", "q", "r", "s")
            '8' -> arrayOf("t", "u", "v")
            '9' -> arrayOf("w", "x", "y", "z")
            else -> arrayOf()
        }
    }
}