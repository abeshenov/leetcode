//       date: 2022-09-27
//      title: Push Dominoes
//        url: https://leetcode.com/problems/push-dominoes/
// difficulty: medium
//------------------------------------------------------------------------------

fun pushDominoes(dominoes: String): String =
    splitGroups("L" + dominoes + "R")
        .map(::transformGroup)
        .stitchGroups()

// A group is a substring of the form (L|R).....(L|R)
// with zero or more dots between first and last letter.
// When splitting in groups, we'll add L at the beginning and R at the end,
// since this doesn't affect the result.
private fun splitGroups(dominoes: String): Sequence<String> =
    sequence {
        var startPos = 0
        var endPos = 1

        while (endPos < dominoes.length) {
            if (dominoes[endPos] != '.') {
                yield(dominoes.substring(startPos..endPos))
                startPos = endPos
            }
            endPos++
        }
    }

private fun transformGroup(group: String) =
    when {
        group.first() == 'L' && group.last() == 'R' -> group
        group.first() == group.last() -> group.first().toString().repeat(group.length)
        else -> group.first().toString().repeat(group.length / 2) +
                (if (group.length % 2 == 1) "." else "") +
                group.last().toString().repeat(group.length / 2)
    }

private fun Sequence<String>.stitchGroups(): String =
    map { it.substring(1) }
        .joinToString("")
        .dropLast(1)

//------------------------------------------------------------------------------

fun pushDominoesInPlace(dominoes: String): String {
    val dominoesDecorated = "L" + dominoes + "R"
    val charArray = dominoesDecorated.toCharArray()

    var startPos = 0
    var endPos = 1

    while (endPos < dominoesDecorated.length) {
        if (charArray[endPos] != '.') {
            transformGroupInPlace(charArray, startPos, endPos)
            startPos = endPos
        }
        endPos++
    }

    return String(charArray).substring(1, charArray.lastIndex)
}

private fun transformGroupInPlace(charArray: CharArray, start: Int, end: Int) {
    // L.....R --> L.....R
    if (charArray[start] == 'L' && charArray[end] == 'R') {
        return
    }

    // L.....L --> LLLLLLL
    // R.....R --> RRRRRRR
    if (charArray[start] == charArray[end]) {
        for (i in start + 1 until end) {
            charArray[i] = charArray[start]
        }
    }

    // R.....L --> RRR.LLL
    // R....L  --> RRRLLL
    if (charArray[start] == 'R' && charArray[end] == 'L') {
        for (i in start + 1 until end) {
            charArray[i] = when {
                i - start < end - i -> 'R'
                i - start > end - i -> 'L'
                else -> '.'
            }
        }
    }
}
