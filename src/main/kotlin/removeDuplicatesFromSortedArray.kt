//      title: Remove Duplicates from Sorted Array
//        url: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
// difficulty: easy
//------------------------------------------------------------------------------

fun removeDuplicates(nums: IntArray): Int {
    var i = 0
    var j = 1

    var count = 1

    while (j < nums.size) {
        if (nums[i] != nums[j]) {
            nums[i+1] = nums[j]
            i++
            count++
        }
        j++
    }

    return count
}
