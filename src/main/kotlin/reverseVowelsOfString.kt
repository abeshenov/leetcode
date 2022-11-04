//       date: 2022-11-04
//      title: Reverse Vowels of a String
//        url: https://leetcode.com/problems/reverse-vowels-of-a-string/
// difficulty: easy
//------------------------------------------------------------------------------

fun reverseVowels(s: String): String {
    val characters = s.toCharArray()

    var left = 0
    var right = characters.lastIndex

    while (left < right) {
        while (left < right && !isVowel(characters[left])) {
            left++
        }
        while (left < right && !isVowel(characters[right])) {
            right--
        }

        val tmp = characters[left]
        characters[left] = characters[right]
        characters[right] = tmp

        left++
        right--
    }

    return String(characters)
}

private fun isVowel(chr: Char): Boolean = chr in "AEIOUaeiou"
