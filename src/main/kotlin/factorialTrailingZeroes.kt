// https://leetcode.com/problems/factorial-trailing-zeroes/

fun trailingZeroes(n: Int): Int =
    Math.min(legendre(n, 2), legendre(n, 5))

// See Legendre's formula for v_p (n!)
// https://en.wikipedia.org/wiki/Legendre%27s_formula
private fun legendre(n: Int, p: Int): Int {
    var v = 0
    var i = 1

    while (intPow(p,i) <= n) {
        v += n / intPow(p,i)
        i++
    }

    return v
}

private fun intPow(n: Int, k: Int): Int =
    when {
        k == 0 -> 1
        k % 2 == 0 -> sqr(intPow(n, k / 2))
        else -> sqr(intPow(n, k / 2)) * n
    }

private fun sqr(x: Int): Int = x * x
