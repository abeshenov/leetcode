// https://leetcode.com/problems/reverse-words-in-a-string-iii/

// This is cheating, but we can also reimplement things from scratch

fun reverseWords(s: String): String =
    s.split(" ").joinToString(" ") { it.reversed() }
