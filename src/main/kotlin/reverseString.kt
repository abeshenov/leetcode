//      title: Reverse String
//        url: https://leetcode.com/problems/reverse-string/
// difficulty: easy
//------------------------------------------------------------------------------

fun reverseString(s: CharArray) {
    var left = 0
    var right = s.size - 1

    while (left < right) {
        val tmp = s[right]
        s[right] = s[left]
        s[left] = tmp

        left++
        right--
    }
}
