//      title: Reverse Words in a String III
//        url: https://leetcode.com/problems/reverse-words-in-a-string-iii/
// difficulty: easy
//------------------------------------------------------------------------------

// This is cheating, but we can also reimplement things from scratch.
// The two-pointer solution is straightforward.
fun reverseWords(s: String): String =
    s.split(" ").joinToString(" ") { it.reversed() }
