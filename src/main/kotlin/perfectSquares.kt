//       date: 2022-11-22
//      title: Perfect Squares
//        url: https://leetcode.com/problems/perfect-squares/
// difficulty: medium
//------------------------------------------------------------------------------

fun numSquares(n: Int): Int =
    when {
        isSquare(n) -> 1
        twoSquares(n) -> 2
        threeSquares(n) -> 3
        else -> 4
    }

// Case of one square: let's calculate the integer square root of n
// and check if squaring it gives n.

private fun isSquare(n: Int): Boolean {
    val sqr = intSqrt(n)
    return n == sqr*sqr
}

private fun intSqrt(n: Int): Int {
    if (n == 0) {
        return 0
    }

    var lower = 0
    var upper = 46341  // 46340^2 < 2^31 - 1 < 46341^2

    while (lower < upper) {
        val mid = lower + (upper - lower)/2

        if (mid*mid > n) {
            upper = mid
        }
        else {
            lower = mid + 1
        }
    }

    return upper - 1
}

// Two-square theorem:
//   a number is a sum of two squares, unless it has a factor
//   p^k with p = 3 (4) and k odd.

private fun primeSieve(n: Int): List<Int> {
    val arr = BooleanArray(n + 1) { true }

    arr[0] = false

    if (n >= 1) {
        arr[1] = false
    }

    if (n >= 2) {
        arr[2] = false
    }

    for (i in 2 until intSqrt(n)) {
        if (!arr[i]) {
            continue
        }

        var j = i + i
        while (j < n) {
            arr[j] = false
            j += i
        }
    }

    return arr.withIndex()
        .filter { it.value }
        .map { it.index }
}

private fun twoSquares(n: Int): Boolean {
    for (p in primeSieve(n)) {
        if (p % 4 == 3 && n % p == 0 && valuation(n, p) % 2 == 1) {
            return false
        }
    }

    return true
}

private fun valuation(n: Int, p: Int): Int {
    var v = 0
    var m = n

    while (m % p == 0) {
        m /= p
        v++
    }

    return v
}

// Three-square theorem:
//   a number is a sum of three squares, unless
//   n = 4^a (8b + 7)
// The first such n are 7, 15, 23, 28, 31, 39, 47, 55, 60, 63, ...

private fun threeSquares(n: Int): Boolean =
    removeFactor(n, 4) % 8 != 7

private fun removeFactor(n: Int, p: Int): Int {
    var m = n

    while (m % p == 0) {
        m /= p
    }

    return m
}

// Four-square theorem: any number is a sum of four squares.
