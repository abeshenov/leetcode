//      title: Missing Number
//        url: https://leetcode.com/problems/missing-number/
// difficulty: easy
//------------------------------------------------------------------------------

// 1 + 2 + ... + n = n * (n + 1) / 2
fun missingNumber(nums: IntArray): Int =
    nums.size * (nums.size + 1) / 2 - nums.sum()
