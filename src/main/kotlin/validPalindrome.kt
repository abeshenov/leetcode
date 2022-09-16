// https://leetcode.com/problems/valid-palindrome/

fun isPalindrome(s: String): Boolean {
    var left = 0
    var right = s.length - 1

    while (left < right) {
        while (left < right && !s[left].isLetterOrDigit()) {
            left += 1
        }
        while (left < right && !s[right].isLetterOrDigit()) {
            right -= 1
        }

        if (s[left].lowercaseChar() != s[right].lowercaseChar()) {
            return false
        }

        left += 1
        right -= 1
    }

    return true
}
