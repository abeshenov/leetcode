// https://leetcode.com/problems/valid-anagram/

fun isAnagram(s: String, t: String): Boolean =
    s.length == t.length && letterFrequencies(s) contentEquals letterFrequencies(t)

private fun letterFrequencies(str: String): IntArray {
    val frequencies = IntArray(26) { 0 }

    for (chr in str) {
        frequencies[chr.code - 'a'.code]++
    }

    return frequencies
}
