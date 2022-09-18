//      title: Valid Parentheses
//        url: https://leetcode.com/problems/valid-parentheses/
// difficulty: easy
//------------------------------------------------------------------------------

import java.util.Stack

fun isValid(s: String): Boolean {
    val stack: Stack<Char> = Stack()

    for (chr in s) {
        if (isOpeningParenthesis(chr)) {
            stack.push(chr)
        } else if (isClosingParenthesis(chr) && (stack.size == 0 || stack.pop() != pairParenthesis(chr))) {
            return false
        }
    }

    return stack.isEmpty()
}

private fun isOpeningParenthesis(chr: Char): Boolean =
    chr == '(' || chr == '[' || chr == '{'

private fun isClosingParenthesis(chr: Char): Boolean =
    chr == ')' || chr == ']' || chr == '}'

private fun pairParenthesis(chr: Char): Char =
    when (chr) {
        ')' -> '('
        '(' -> ')'
        ']' -> '['
        '[' -> ']'
        '{' -> '}'
        '}' -> '{'
        else -> '?'
    }
