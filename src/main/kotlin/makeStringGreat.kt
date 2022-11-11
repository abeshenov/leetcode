//       date: 2022-11-08
//      title: Make The String Great
//        url: https://leetcode.com/problems/make-the-string-great/
// difficulty: easy
//------------------------------------------------------------------------------

import java.util.Stack
import kotlin.math.abs

// For the trivial recursive solution, see the Haskell version
fun makeGood(s: String): String {
    val stack = Stack<Char>()

    for (currentChar in s.toCharArray()) {
        if (!stack.isEmpty() && abs(stack.lastElement().code - currentChar.code) == 32) {
            stack.pop()
        } else {
            stack.add(currentChar)
        }
    }

    return stack.joinToString("")
}
