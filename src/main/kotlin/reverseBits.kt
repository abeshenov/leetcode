//      title: Reverse Bits
//        url: https://leetcode.com/problems/reverse-bits/
// difficulty: easy
//------------------------------------------------------------------------------

fun reverseBits(n: Int): Int {
    var num = n
    var rev = 0

    repeat(32) {
        rev = (rev shl 1) or (num and 1)
        num = num ushr 1
    }

    return rev
}
