//       date: 2022-12-01
//      title: Determine if String Halves Are Alike
//        url: https://leetcode.com/problems/determine-if-string-halves-are-alike/
// difficulty: easy
//------------------------------------------------------------------------------

fun halvesAreAlike(s: String): Boolean =
    s.substring(0 until s.length/2).vowelCount() ==
            s.substring(s.length/2 until s.length).vowelCount()

private const val vowels = "aeiouAEIOU"

private fun String.vowelCount(): Int = count { it in vowels }
