//       date: 2022-09-23
//      title: Concatenation of Consecutive Binary Numbers
//        url: https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/
// difficulty: medium
//------------------------------------------------------------------------------

// The recursion is
//   a(1) = 1,
//   a(i) = a(i-1) * 2^bd(i) + i  for  i > 2.

// Here bd(i) is the number of binary digits in i.
// It can be calculated with
//   bd(1) = 1,
//   bd(i) = 1 + bd(floor(i/2)).

// For f(i) = 2^bd(i) we have
//   f(1) = 2,
//   f(i) = 2 f(floor(i/2)).

private val MODULUS = 1000000007

fun concatenatedBinary(n: Int): Int {
    val f = LongArray(n + 1)
    f[1] = 2L
    var a = 1L

    for (i in 2..n) {
        f[i] = (2 * f[i / 2]) % MODULUS
        a = ((a * f[i]) % MODULUS + i) % MODULUS
    }

    return a.toInt()
}
