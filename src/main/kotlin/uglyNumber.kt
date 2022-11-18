//       date: 2022-11-18
//      title: Ugly Number
//        url: https://leetcode.com/problems/ugly-number/
// difficulty: easy
//------------------------------------------------------------------------------

fun isUgly(n: Int): Boolean =
    listOf(2, 3, 5).fold(n) { m, p -> reduceFactors(m, p) } == 1

private tailrec fun reduceFactors(m: Int, p: Int): Int =
    if (m == 0 || m%p != 0) m else reduceFactors(m/p, p)
