//       date: 2022-11-11
//      title: Remove Duplicates from Sorted Array
//        url: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
// difficulty: easy
//------------------------------------------------------------------------------

// The problem asks to do this in-place;
// see the Haskell version for a pure solution
fun removeDuplicates(nums: IntArray): Int {
    var i = 0
    var j = 1

    while (j < nums.size) {
        if (nums[i] != nums[j]) {
            i++
            nums[i] = nums[j]
        }
        j++
    }

    return i + 1
}
