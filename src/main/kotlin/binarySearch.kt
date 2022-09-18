//      title: Binary Search
//        url: https://leetcode.com/problems/binary-search/
// difficulty: easy
//------------------------------------------------------------------------------

fun search(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1

    while (left <= right) {
        val midpoint = left + (right - left)/2

        if (target == nums[midpoint]) {
            return midpoint
        }

        if (target < nums[midpoint]) {
            right = midpoint - 1
        }

        if (target > nums[midpoint]) {
            left = midpoint + 1
        }
    }

    return -1
}
