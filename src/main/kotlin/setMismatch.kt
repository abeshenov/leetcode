//       date: 2022-10-23
//      title: Set Mismatch
//        url: https://leetcode.com/problems/set-mismatch/
// difficulty: easy
//------------------------------------------------------------------------------

// Cf. https://github.com/abeshenov/leetcode/blob/main/haskell/SetMismatch.hs
fun findErrorNums(nums: IntArray): IntArray {
    val sumDiff = nums.withIndex().sumOf { it.value - (it.index + 1) }
    val sumOfSquaresDiff = nums.withIndex().sumOf { it.value * it.value - (it.index + 1) * (it.index + 1) }

    return intArrayOf(
        (sumOfSquaresDiff + sumDiff * sumDiff) / (2 * sumDiff),
        (sumOfSquaresDiff - sumDiff * sumDiff) / (2 * sumDiff)
    )
}
