// 2022-09-16
// https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/

fun maximumScore(nums: IntArray, multipliers: IntArray): Int =
    DpHelper(nums, multipliers).calculate()

// Denote
//   leftSkipped  := number of elements skipped from the beginning of nums
//   rightSkipped := number of elements skipped from the end of nums
//
// The current step is then leftSkipped + rightSkipped.
//
// We want to use memoization, otherwise we end up traversing the whole
// binary tree with 2^m nodes.

private class DpHelper(val nums: IntArray, val multipliers: IntArray) {

    private val memo: Array<Array<Int?>> = Array(multipliers.size) { Array(multipliers.size) { null } }

    fun calculate(leftSkipped: Int = 0, rightSkipped: Int = 0): Int {
        val step = leftSkipped + rightSkipped

        if (step == multipliers.size) {
            return 0
        }

        val memoizedAnswer: Int? = memo[leftSkipped][rightSkipped]
        if (memoizedAnswer != null) {
            return memoizedAnswer
        }

        // If we choose the left branch:
        val leftValue = nums[leftSkipped] * multipliers[step] + calculate(leftSkipped + 1, rightSkipped)

        // If we choose the right branch:
        val rightPosition = nums.lastIndex - rightSkipped
        val rightValue = nums[rightPosition] * multipliers[step] + calculate(leftSkipped, rightSkipped + 1)

        val result = Math.max(leftValue, rightValue)
        memo[leftSkipped][rightSkipped] = result

        return result
    }

}
