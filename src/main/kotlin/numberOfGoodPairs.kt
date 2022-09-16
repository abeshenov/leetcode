// https://leetcode.com/problems/number-of-good-pairs/

fun numIdenticalPairs(nums: IntArray) =
    frequencies(nums).values.sumOf { fr -> (fr * (fr - 1)) / 2 }

private fun frequencies(nums: IntArray): Map<Int,Int> {
    val freqMap: MutableMap<Int,Int> = mutableMapOf()

    nums.forEach {
        freqMap[it] = freqMap.getOrDefault(it, 0) + 1
    }

    return freqMap
}
