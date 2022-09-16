// https://leetcode.com/problems/valid-perfect-square/

fun isPerfectSquare(num: Int): Boolean {
    var lower = 0
    var upper = 46341

    while (lower < upper) {
        val mid = lower + (upper - lower) / 2

        when {
            mid * mid > num -> upper = mid
            mid * mid == num -> return true
            mid * mid < num -> lower = mid + 1
        }
    }

    return false
}
