//       date: 2022-09-20
//      title: Maximum Length of Repeated Subarray
//        url: https://leetcode.com/problems/maximum-length-of-repeated-subarray/
// difficulty: medium
//------------------------------------------------------------------------------

fun findLength(nums1: IntArray, nums2: IntArray): Int {
    // dp[i][j] = length of common subarray
    //            starting from i in A,
    //            starting from j in B
    val dp: Array<IntArray> = Array(nums1.size + 1) { IntArray(nums2.size + 1) { 0 } }

    // We initialize dp[nums1.lastIndex + 1][nums2.lastIndex + 1] = 0
    // and loop through i and j from lastIndex to 0 to fill the table.

    // In the same loop, we'll update the maximum.

    var result = 0

    for (i in nums1.indices.reversed()) {
        for (j in nums2.indices.reversed()) {
            dp[i][j] = if (nums1[i] == nums2[j]) dp[i + 1][j + 1] + 1 else 0
            result = Math.max(result, dp[i][j])
        }
    }

    return result
}
