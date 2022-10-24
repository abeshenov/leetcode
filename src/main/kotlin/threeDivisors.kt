//      title: Three Divisors
//        url: https://leetcode.com/problems/three-divisors/
// difficulty: easy
//------------------------------------------------------------------------------
import kotlin.math.floor
import kotlin.math.sqrt

fun isThree(n: Int): Boolean {
    val sq = isqrt(n)
    return n == sq * sq && isPrime(sq)
}

private fun isqrt(n: Int): Int =
    floor(sqrt(1.0 * n)).toInt()

fun isPrime(n: Int): Boolean =
    (n >= 2) && (2..isqrt(n)).all { n % it != 0 }
