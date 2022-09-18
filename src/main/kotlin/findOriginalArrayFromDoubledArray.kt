//       date: 2022-09-15
//      title: Find Original Array From Doubled Array
//        url: https://leetcode.com/problems/find-original-array-from-doubled-array/
// difficulty: medium
//------------------------------------------------------------------------------

fun findOriginalArray(changed: IntArray): IntArray {
    if (changed.size % 2 != 0) {
        return intArrayOf()
    }

    val frequencies: MutableMap<Int,Int> = mutableMapOf()

    for (elem in changed) {
        frequencies[elem] = frequencies.getOrDefault(elem, 0) + 1
    }

    val result = IntArray(changed.size/2)
    var pos = 0

    changed.sort()  // in-place

    for (elem in changed) {
        val frequency = frequencies[elem]!!

        if (frequency <= 0) {
            continue  // the element was deleted before
        }

        result[pos] = elem
        pos++

        frequencies[elem] = frequency - 1

        val frequencyOfDouble = frequencies[2*elem]
        if (frequencyOfDouble == null || frequencyOfDouble <= 0) {
            return intArrayOf()
        }

        frequencies[2*elem] = frequencyOfDouble - 1
    }

    return result
}
