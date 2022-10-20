//       date: 2022-10-20
//      title: Integer to Roman
//        url: https://leetcode.com/problems/integer-to-roman/
// difficulty: medium
//------------------------------------------------------------------------------

private val romanDigits: List<Pair<Int, String>> = listOf(
    Pair(1000, "M"),
    Pair(900, "CM"),
    Pair(500, "D"),
    Pair(400, "CD"),
    Pair(100, "C"),
    Pair(90, "XC"),
    Pair(50, "L"),
    Pair(40, "XL"),
    Pair(10, "X"),
    Pair(9, "IX"),
    Pair(5, "V"),
    Pair(4, "IV"),
    Pair(1, "I")
)

fun intToRoman(num: Int): String {
    var currentValue = num

    val result = StringBuilder()
    for ((value, digit) in romanDigits) {
        repeat(currentValue / value) { result.append(digit) }
        currentValue %= value

        if (currentValue == 0) {
            return result.toString()
        }
    }

    return result.toString()
}
