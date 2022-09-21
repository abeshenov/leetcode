//       date: 2022-09-21
//      title: Sum of Even Numbers After Queries
//        url: https://leetcode.com/problems/sum-of-even-numbers-after-queries/
// difficulty: medium
//------------------------------------------------------------------------------

fun sumEvenAfterQueries(nums: IntArray, queries: Array<IntArray>): IntArray {
    var currentEvenSum = nums.filter { it % 2 == 0 }.sum()
    val result = IntArray(queries.size) { 0 }

    for (i in 0..queries.lastIndex) {
        val (value, index) = queries[i]

        currentEvenSum += when {
            nums[index] % 2 == 0 && value % 2 == 0 -> value
            nums[index] % 2 == 0 && value % 2 != 0 -> -nums[index]
            nums[index] % 2 != 0 && value % 2 == 0 -> 0
            nums[index] % 2 != 0 && value % 2 != 0 -> nums[index] + value
            else -> 0  // unreachable
        }

        nums[index] += value
        result[i] = currentEvenSum
    }

    return result
}
