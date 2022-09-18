//      title: N-th Tribonacci Number
//        url: https://leetcode.com/problems/n-th-tribonacci-number/
// difficulty: easy
//------------------------------------------------------------------------------

fun tribonacci(n: Int): Int {
    when (n) {
        0 -> return 0
        1 -> return 1
        2 -> return 1
    }

    var x = 0
    var y = 1
    var z = 1

    var i = 2

    while (i < n) {
        val newTerm = x + y + z
        x = y
        y = z
        z = newTerm
        i++
    }

    return z
}
