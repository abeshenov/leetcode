//       date: 2022-12-03
//      title: Sort Characters By Frequency
//        url: https://leetcode.com/problems/sort-characters-by-frequency/
// difficulty: medium
//------------------------------------------------------------------------------

import java.util.PriorityQueue

fun frequencySort(s: String): String {
    val frequencies: Map<Char,Int> = s.frequencies()

    val pairComparator: Comparator<Map.Entry<Char,Int>> =
        compareBy<Map.Entry<Char, Int>> { -it.value }
            .thenBy { -it.key.code }

    val priorityQueue: PriorityQueue<Map.Entry<Char,Int>> = PriorityQueue(pairComparator)

    priorityQueue.addAll(frequencies.entries)

    val result = StringBuilder()

    while (priorityQueue.isNotEmpty()) {
        val entry = priorityQueue.poll()
        repeat(entry.value) {
            result.append(entry.key)
        }
    }

    return result.toString()
}

private fun String.frequencies(): Map<Char,Int> {
    val result = mutableMapOf<Char,Int>()

    forEach { chr ->
        result.computeIfAbsent(chr) { 0 }
        result[chr] = result[chr]!! + 1
    }

    return result
}
