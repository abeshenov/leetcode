//       date: 2022-10-10
//      title: Break a Palindrome
//        url: https://leetcode.com/problems/break-a-palindrome/
// difficulty: medium
//------------------------------------------------------------------------------

fun breakPalindrome(palindrome: String): String =
    when {
        palindrome.length == 1 -> ""
        canReplaceFirstNotA(palindrome) -> replaceFirstNotA(palindrome)
        else -> replaceLastA(palindrome)
    }

// Contains character distinct from 'a', not in the middle
private fun canReplaceFirstNotA(str: String): Boolean =
    str.subSequence(0, str.lastIndex / 2).find { it != 'a' } != null

private fun replaceFirstNotA(str: String) =
    str.replaceFirst(Regex("[^a]"), "a")

private fun replaceLastA(str: String) =
    str.reversed().replaceFirst('a', 'b').reversed()
