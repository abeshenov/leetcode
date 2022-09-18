//      title: Backspace String Compare
//        url: https://leetcode.com/problems/backspace-string-compare/
// difficulty: easy
//------------------------------------------------------------------------------

fun backspaceCompare(s: String, t: String): Boolean =
    s.applyBackspace() == t.applyBackspace()

private fun String.applyBackspace(backspaceChar: Char = '#'): String {
    val sb = StringBuilder()

    for (chr in this) {
        if (chr == backspaceChar) {
            if (sb.isNotEmpty()) {
                sb.deleteCharAt(sb.length - 1)
            }
        } else {
            sb.append(chr)
        }
    }

    return sb.toString()
}

//------------------------------------------------------------------------------

// A variation: reverse the string, use sequences
fun backspaceCompareSeq(s: String, t: String): Boolean =
    s.backspaceRevSeq().equalsTo(t.backspaceRevSeq())

private fun String.backspaceRevSeq(backspaceChar: Char = '#'): Sequence<Char> =
    sequence {
        var charactersToSkip = 0

        for (chr in reversed()) {
            if (chr == backspaceChar) {
                charactersToSkip++
            } else if (charactersToSkip == 0) {
                yield(chr)
            } else {
                charactersToSkip--
            }
        }
    }

// This looks dumb, but Kotlin's zip trims to the shortest sequence...
private fun <T> Sequence<T>.equalsTo(seq: Sequence<T>): Boolean {
    val iter = iterator()
    val otherIter = seq.iterator()

    while (iter.hasNext() && otherIter.hasNext()) {
        if (iter.next() != otherIter.next()) {
            return false
        }
    }

    return !iter.hasNext() && !otherIter.hasNext()
}
