//       date: 2022-09-22
//      title: Reverse Words in a String III
//        url: https://leetcode.com/problems/reverse-words-in-a-string-iii/
// difficulty: easy
//------------------------------------------------------------------------------

import java.util.Stack

// This is cheating, but we can also reimplement things from scratch :-)
fun reverseWords3(s: String): String =
    s.split(" ").joinToString(" ") { it.reversed() }

// Using stack
fun reverseWordsStack(s: String): String {
    val charStack: Stack<Char> = Stack()
    val result = StringBuilder()

    for (chr in s) {
        if (chr == ' ') {
            while (charStack.isNotEmpty()) {
                result.append(charStack.pop())
            }
            result.append(chr)
        } else {
            charStack.push(chr)
        }
    }

    while (charStack.isNotEmpty()) {
        result.append(charStack.pop())
    }

    return result.toString()
}

// Two pointer approach
fun reverseWordsTwoPointers(s: String): String {
    val bytes: ByteArray = s.toByteArray()

    var i = 0
    while (i < bytes.size) {
        var j = i

        // Make j point to the place after the word end :
        while (j < bytes.size && bytes[j] != ' '.code.toByte()) {
            j++
        }

        inPlaceReverse(bytes, i, j - 1)

        i = j + 1
    }

    return String(bytes)
}

private tailrec fun inPlaceReverse(arr: ByteArray, start: Int = 0, end: Int = arr.lastIndex) {
    if ((0 <= start) && (start < end) && (end < arr.size)) {
        val tmp = arr[start]
        arr[start] = arr[end]
        arr[end] = tmp

        inPlaceReverse(arr, start + 1, end - 1)
    }
}
