//       date: 2022-11-02
//      title: Minimum Genetic Mutation
//        url: https://leetcode.com/problems/minimum-genetic-mutation/
// difficulty: medium
//------------------------------------------------------------------------------

import java.util.LinkedList
import java.util.Queue

fun minMutation(start: String, end: String, bank: Array<String>): Int {
    val bankSet: Set<String> = bank.toSet()

    val queue: Queue<String> = LinkedList()
    queue.add(start)

    val seenStrings: MutableSet<String> = mutableSetOf(start)

    var mutationCount = 0

    while (queue.isNotEmpty()) {
        repeat(queue.size) {
            val str = queue.poll()

            if (str == end) {
                return mutationCount
            }

            for (mutatedStr in mutations(str)) {
                if (bankSet.contains(mutatedStr) &&
                    !seenStrings.contains(mutatedStr)
                ) {
                    queue.add(mutatedStr)
                    seenStrings.add(mutatedStr)
                }
            }
        }

        mutationCount++
    }

    return -1
}

private val letters = listOf('A', 'C', 'G', 'T')

private fun mutations(str: String): Sequence<String> =
    sequence {
        for (i in str.indices) {
            for (letter in letters) {
                if (str[i] != letter) {
                    yield(mutate(str, i, letter))
                }
            }
        }
    }

private fun mutate(str: String, pos: Int, letter: Char): String =
    str.substring(0, pos) + letter + str.substring(pos + 1)
