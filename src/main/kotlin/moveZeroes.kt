// https://leetcode.com/problems/move-zeroes/

fun moveZeroes(nums: IntArray) {
    var nextNonZero = 0
    var current = 0

    while (nextNonZero < nums.size) {
        while (nextNonZero < nums.size && nums[nextNonZero] == 0) {
            nextNonZero++
        }

        if (nextNonZero < nums.size) {
            nums[current] = nums[nextNonZero]
            current++
            nextNonZero++
        }
    }

    while (current < nums.size) {
        nums[current] = 0
        current++
    }
}
