//      title: Kth Largest Element in an Array
//        url: https://leetcode.com/problems/kth-largest-element-in-an-array/
// difficulty: medium
//------------------------------------------------------------------------------

fun findKthLargest(nums: IntArray, k: Int): Int =
    quickSelect(nums.toList(), k)

// See https://en.wikipedia.org/wiki/Quickselect
private tailrec fun quickSelect(nums: List<Int>, k: Int): Int {
    if (nums.isEmpty()) {
        return 0
    }

    val x = nums[0]

    val smaller = nums.filter { it < x }
    val equal = nums.filter { it == x }
    val bigger = nums.filter { it > x }

    return when {
        k <= bigger.size -> quickSelect(bigger, k)
        k > bigger.size + equal.size -> quickSelect(smaller, k - bigger.size - equal.size)
        else -> x
    }
}
