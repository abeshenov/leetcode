//      title: Number of 1 Bits
//        url: https://leetcode.com/problems/number-of-1-bits/
// difficulty: easy
//------------------------------------------------------------------------------

fun hammingWeight(n: Int): Int {
    var bitCount = 0
    var num = n

    while (num != 0) {
        bitCount += (num and 1)
        num = num ushr 1
    }

    return bitCount
}
