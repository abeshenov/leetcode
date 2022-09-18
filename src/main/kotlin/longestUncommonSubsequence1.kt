//      title: Longest Uncommon Subsequence I
//        url: https://leetcode.com/problems/longest-uncommon-subsequence-i/
// difficulty: easy
//------------------------------------------------------------------------------

fun findLUSlength(a: String, b: String): Int =
    if (a == b) -1 else maxOf(a.length, b.length)
