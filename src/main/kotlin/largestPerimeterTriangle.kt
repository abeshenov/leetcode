//       date: 2022-10-12
//      title: Largest Perimeter Triangle
//        url: https://leetcode.com/problems/largest-perimeter-triangle/
// difficulty: easy
//------------------------------------------------------------------------------

import java.util.Arrays

fun largestPerimeter(nums: IntArray): Int {
    Arrays.sort(nums)
    for (i in nums.size - 3 downTo 0) {
        if (isTriangle(nums[i], nums[i+1], nums[i+2])) {
            return nums[i] + nums[i + 1] + nums[i + 2]
        }
    }
    return 0
}

private fun isTriangle(a: Int, b: Int, c: Int): Boolean =
    a + b > c
