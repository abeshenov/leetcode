//       date: 2022-11-30
//      title: Unique Number of Occurrences
//        url: https://leetcode.com/problems/unique-number-of-occurrences/
// difficulty: easy
//------------------------------------------------------------------------------

fun uniqueOccurrences(arr: IntArray): Boolean =
    arr.frequencies().values.hasUniqueElements()

private fun IntArray.frequencies(): Map<Int,Int> {
    val frequencies: MutableMap<Int,Int> = mutableMapOf()

    forEach {
        frequencies.computeIfAbsent(it) { 0 }
        frequencies[it] = frequencies[it]!!.plus(1)
    }

    return frequencies
}

private fun <T> Collection<T>.hasUniqueElements(): Boolean {
    val elements: MutableSet<T> = mutableSetOf()

    forEach {
        if (it in elements) {
            return false
        } else {
            elements.add(it)
        }
    }

    return true
}
