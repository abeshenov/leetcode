//      title: Maximum Subarray
//        url: https://leetcode.com/problems/maximum-subarray/
// difficulty: medium
//------------------------------------------------------------------------------

// https://en.wikipedia.org/wiki/Maximum_subarray_problem
fun maxSubArray(nums: IntArray): Int {
    var bestSum = Int.MIN_VALUE
    var currentSum = 0

    for (x in nums) {
        currentSum = Math.max(x, currentSum + x)
        bestSum = Math.max(bestSum, currentSum)
    }
    return bestSum
}
