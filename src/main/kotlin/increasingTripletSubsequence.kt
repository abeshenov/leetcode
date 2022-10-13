//       date: 2022-10-11
//      title: Increasing Triplet Subsequence
//        url: https://leetcode.com/problems/increasing-triplet-subsequence/
// difficulty: medium
//------------------------------------------------------------------------------

fun increasingTriplet(nums: IntArray): Boolean {
    var first = Int.MAX_VALUE
    var second = Int.MAX_VALUE

    for (third in nums) {
        if (third > first && third > second) {
            return true
        }

        if (third <= first) {
            first = third
        }
        else {  // first < third <= second
            second = third
        }
    }

    return false
}
