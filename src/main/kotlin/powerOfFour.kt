// https://leetcode.com/problems/power-of-four/

fun isPowerOfFour(n: Int): Boolean {
    if (n <= 0) {
        return false
    }

    var currentValue = n

    while (currentValue != 1) {
        if (currentValue and 11 != 0) {  // != 0 (mod 4)
            return false
        } else {
            currentValue = currentValue ushr 2  // divide by 4
        }
    }
    return true
}

// There are not that many powers of 4 fitting in Int
fun isPowerOfFourCheatingAnswer(n: Int): Boolean =
    generateSequence(1) { x -> 4*x }.take(16).contains(n)
