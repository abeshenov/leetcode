// https://leetcode.com/problems/intersection-of-two-arrays-ii/

fun intersect(nums1: IntArray, nums2: IntArray): IntArray =
    toIntArray(frequencyIntersection(frequencies(nums1), frequencies(nums2)))

private fun frequencies(nums: IntArray): Map<Int,Int> {
    val freqMap: MutableMap<Int,Int> = mutableMapOf()

    nums.forEach {
        freqMap[it] = freqMap.getOrDefault(it, 0) + 1
    }

    return freqMap
}

private fun frequencyIntersection(nums1: Map<Int,Int>, nums2: Map<Int,Int>): Sequence<Pair<Int,Int>> =
    nums1.keys.union(nums2.keys).map {
        it to Math.min(
            nums1.getOrDefault(it, 0),
            nums2.getOrDefault(it, 0)
        )
    }.asSequence()

private fun toIntArray(frequencies: Sequence<Pair<Int,Int>>): IntArray =
    frequencies.toList().flatMap { (elem, freq) -> List(freq) { elem } }
        .toIntArray()
