//      title: Power of Three
//        url: https://leetcode.com/problems/power-of-three/
// difficulty: easy
//------------------------------------------------------------------------------

fun isPowerOfThree(n: Int): Boolean {
    if (n <= 0) {
        return false
    }

    var currentValue = n

    while (currentValue != 1) {
        if (currentValue % 3 != 0) {
            return false
        } else {
            currentValue /= 3
        }
    }

    return true
}
