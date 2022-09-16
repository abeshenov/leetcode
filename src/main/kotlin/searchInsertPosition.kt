// https://leetcode.com/problems/search-insert-position/

fun searchInsert(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1

    if (target > nums[right]) {
        return nums.size
    }

    while (left < right) {
        val midpoint = left + (right - left)/2

        if (nums[midpoint] == target) {
            return midpoint
        }

        if (nums[midpoint] > target) {
            right = midpoint
        } else {
            left = midpoint + 1
        }
    }

    return left
}
