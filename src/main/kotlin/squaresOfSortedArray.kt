// https://leetcode.com/problems/squares-of-a-sorted-array/

fun sortedSquares(nums: IntArray): IntArray {
    val result = IntArray(nums.size)

    var i = 0     // index running through result
    var iPos = 0  // index running through the numbers >= 0 in nums
    var iNeg = 0  // index running through the numbers <  0 in nums

    while (iPos < nums.size && nums[iPos] < 0) {
        iPos++
    }

    iNeg = iPos - 1

    while (iPos < nums.size && iNeg >= 0) {
        if (-nums[iNeg] <= nums[iPos]) {
            result[i] = nums[iNeg] * nums[iNeg]
            iNeg--
            i++
        } else {
            result[i] = nums[iPos] * nums[iPos]
            iPos++
            i++
        }
    }

    while (iPos < nums.size) {
        result[i] = nums[iPos] * nums[iPos]
        iPos++
        i++
    }

    while (iNeg >= 0) {
        result[i] = nums[iNeg] * nums[iNeg]
        iNeg--
        i++
    }

    return result
}
