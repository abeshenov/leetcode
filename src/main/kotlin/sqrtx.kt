// https://leetcode.com/problems/sqrtx/

fun mySqrt(x: Int): Int {
    if (x == 0) {
        return 0
    }

    var lower = 0
    var upper = 46341  // 46340^2 < 2^31 - 1 < 46341^2

    while (lower < upper) {
        val mid = lower + (upper - lower)/2

        if (mid*mid > x) {
            upper = mid
        }
        else {
            lower = mid + 1
        }
    }

    return upper - 1
}
