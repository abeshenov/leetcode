//       date: 2022-10-01
//      title: Decode Ways
//        url: https://leetcode.com/problems/decode-ways/
// difficulty: medium
//------------------------------------------------------------------------------

// Let dp[i] be the number of ways to decipher the substring 0..i
// Consider the string tail ... s[i-2] s[i-1] s[i].
// a) If a single digit s[i] is a valid number, then dp[i] += dp[i-1]
// b) If s[i-1] s[i] is also a valid number, then dp[i] += dp[i-2]
// c) Otherwise, dp[i] = 0.

fun numDecodings(s: String): Int {
    when (s.length) {
        0 -> {
            return 1
        }

        1 -> {
            return if (isValidCode(s)) 1 else 0
        }

        2 -> {
            val singleOption = if (isValidCode(s)) 1 else 0
            val splitOption = if (isValidCode(s.substring(0..0)) && isValidCode(s.substring(1..1))) 1 else 0

            return singleOption + splitOption
        }
    }

    val dp = IntArray(s.length) { 0 }

    dp[0] = numDecodings(s.substring(0..0))
    dp[1] = numDecodings(s.substring(0..1))

    for (i in 2..dp.lastIndex) {
        if (isValidCode(s.substring(i..i))) {
            dp[i] += dp[i - 1]
        }
        if (isValidCode(s.substring(i - 1..i))) {
            dp[i] += dp[i - 2]
        }
    }

    return dp.last()
}

// Valid numbers are from "1" to "26".
// We should reject strings like "06", only "6" is valid
private fun isValidCode(str: String): Boolean =
    when (str.length) {
        0 -> false
        1 -> str[0] in '1'..'9'
        2 -> str[0] != '0' && Integer.parseInt(str) in 1..26
        else -> false
    }
