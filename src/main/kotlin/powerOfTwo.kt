// https://leetcode.com/problems/power-of-two/

fun isPowerOfTwo(n: Int): Boolean {
    if (n <= 0) {
        return false
    }

    var currentValue = n

    while (currentValue != 1) {
        if (currentValue and 1 != 0) {
            return false
        } else {
            currentValue = currentValue ushr 1
        }
    }

    return true
}
