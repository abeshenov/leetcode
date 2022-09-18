//      title: Two Sum
//        url: https://leetcode.com/problems/two-sum/
// difficulty: easy
//------------------------------------------------------------------------------

fun twoSum(nums: IntArray, target: Int): IntArray {
    val indices: MutableMap<Int, Int> = mutableMapOf()

    for (indexedNum in nums.withIndex()) {
        val complement = target - indexedNum.value
        val complementIndex: Int? = indices[complement]

        if (complementIndex != null) {
            return intArrayOf(complementIndex, indexedNum.index)
        } else {
            indices[indexedNum.value] = indexedNum.index
        }
    }

    return intArrayOf(-1, -1)
}
