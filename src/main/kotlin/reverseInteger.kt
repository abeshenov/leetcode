// https://leetcode.com/problems/reverse-integer/

fun reverse(x: Int): Int {
    var num = x
    var rev = 0
    while (num != 0) {
        val rem = num % 10
        num /= 10
        if (rev > Int.MAX_VALUE / 10 || (rev == Int.MAX_VALUE / 10) && rem > 7) return 0
        if (rev < Int.MIN_VALUE / 10 || (rev == Int.MIN_VALUE / 10) && rem < -8) return 0
        rev = rev * 10 + rem
    }
    return rev
}
