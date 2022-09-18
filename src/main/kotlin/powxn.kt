//      title: Pow(x,n)
//        url: https://leetcode.com/problems/powx-n/
// difficulty: medium
//------------------------------------------------------------------------------

fun myPow(x: Double, n: Int): Double =
    when {
        n == Int.MIN_VALUE -> 1 / x * myPow(x, -n + 1)
        n < 0 -> 1 / myPow(x, -n)
        else -> powRec(x, n)
    }

private fun powRec(x: Double, n: Int): Double =
    when {
        n == 0 -> 1.0
        n % 2 == 0 -> sqr(powRec(x, n / 2))
        else -> sqr(powRec(x, n / 2)) * x
    }

private fun sqr(x: Double): Double = x * x
