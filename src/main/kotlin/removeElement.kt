//       date:
//      title: Remove Element
//        url: https://leetcode.com/problems/remove-element/
// difficulty: easy
//------------------------------------------------------------------------------

fun removeElement(nums: IntArray, `val`: Int): Int {
    var i = 0
    var j = 0

    var count = 0

    while (j < nums.size) {
        if (nums[j] != `val`) {
            nums[i] = nums[j]
            i++
            count++
        }
        j++
    }

    return count
}
