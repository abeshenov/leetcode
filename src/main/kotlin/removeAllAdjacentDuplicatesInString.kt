//       date: 2022-11-10
//      title: Remove All Adjacent Duplicates In String
//        url: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
// difficulty: easy
//------------------------------------------------------------------------------

import java.util.Stack

// For the trivial recursive solution, see the Haskell version
fun removeDuplicates(s: String): String {
    val stack = Stack<Char>()

    for (currentChar in s.toCharArray()) {
        if (!stack.isEmpty() && stack.lastElement() == currentChar) {
            stack.pop()
        } else {
            stack.add(currentChar)
        }
    }

    return stack.joinToString("")
}
