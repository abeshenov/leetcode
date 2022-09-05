// 2022-09-03
// https://leetcode.com/problems/numbers-with-same-consecutive-differences/

fun numsSameConsecDiff(n: Int, k: Int): IntArray =
    (1..9).flatMap { numsSameConsecDiffHelper(it, n, k) }
        .toIntArray()

private fun numsSameConsecDiffHelper(firstDigit: Int, n: Int, k: Int): List<Int> {
    if (n == 1) {
        return listOf(firstDigit)
    }

    val result: MutableList<Int> = mutableListOf()

    if (firstDigit + k <= 9) {
        result.addAll(numsSameConsecDiffHelper(firstDigit + k, n - 1, k))
    }

    if (k > 0 && firstDigit - k >= 0) {
        result.addAll(numsSameConsecDiffHelper(firstDigit - k, n - 1, k))
    }

    return result.map { addDigit(it, n - 1, firstDigit) }
}

private fun addDigit(num: Int, numOfDigits: Int, digit: Int): Int =
    num + pow(10, numOfDigits) * digit

// Because there's no standard pow() for integers
private fun pow(base: Int, exponent: Int): Int {
    if (exponent == 0) {
        return 1
    }

    return if (exponent % 2 == 0) {
        pow(base, exponent / 2) * pow(base, exponent / 2)
    } else {
        base * pow(base, exponent - 1)
    }
}
