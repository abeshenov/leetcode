// https://leetcode.com/problems/xor-operation-in-an-array/

fun xorOperation(n: Int, start: Int) =
    (0 until n).fold(0) { acc: Int, i: Int -> acc xor start + 2 * i }
