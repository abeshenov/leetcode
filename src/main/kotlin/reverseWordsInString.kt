//       date: 2022-11-13
//      title: Reverse Words in a String
//        url: https://leetcode.com/problems/reverse-words-in-a-string/
// difficulty: easy
//------------------------------------------------------------------------------

fun reverseWords(s: String): String =
    s.split(" ")
        .filter { it.isNotEmpty() }
        .reversed()
        .joinToString(" ") { it }
