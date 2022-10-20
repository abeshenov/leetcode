//       date: 2022-10-18
//      title: Count and Say
//        url: https://leetcode.com/problems/count-and-say/
// difficulty: medium
//------------------------------------------------------------------------------

fun countAndSay(n: Int): String =
    if (n == 1) "1" else say(countAndSay(n - 1))

fun say(x: String): String =
    x.group().map(::sayGroup).joinToString(separator = "") { it }

fun sayGroup(s: String): String =
    s.length.toString() + s.first()

// Works like group :: Eq a => [a] -> [[a]] from Data.List
fun String.group(): List<String> {
    val result: MutableList<StringBuilder> = mutableListOf()

    for (c in this) {
        if (result.isEmpty() || (result.last().isNotEmpty() && result.last().last() != c)) {
            result.add(StringBuilder())
        }
        result.last().append(c)
    }

    return result.map { it.toString() }
}
