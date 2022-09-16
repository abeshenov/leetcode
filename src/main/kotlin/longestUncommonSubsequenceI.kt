// https://leetcode.com/problems/longest-uncommon-subsequence-i/

fun findLUSlength(a: String, b: String): Int =
    if (a == b) -1 else maxOf(a.length, b.length)
