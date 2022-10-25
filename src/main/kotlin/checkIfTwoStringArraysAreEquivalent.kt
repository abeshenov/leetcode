//       date: 2022-10-25
//      title: Check If Two String Arrays are Equivalent
//        url: https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
// difficulty: easy
//------------------------------------------------------------------------------

fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean =
    word1.joinToString("") == word2.joinToString("")

fun arrayStringsAreEqualSeq(word1: Array<String>, word2: Array<String>): Boolean {
    if (word1.sumOf { it.length } != word2.sumOf { it.length }) {
        return false
    }
    val seq1 = word1.asSequence().flatMap { it.asSequence() }
    val seq2 = word2.asSequence().flatMap { it.asSequence() }
    return seq1.zip(seq2).all { it.first == it.second }
}
