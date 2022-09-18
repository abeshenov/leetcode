//      title: Contains Duplicate
//        url: https://leetcode.com/problems/contains-duplicate/
// difficulty: easy
//------------------------------------------------------------------------------

fun containsDuplicate(nums: IntArray): Boolean {
    val numSet: MutableSet<Int> = mutableSetOf()

    for (num in nums) {
        if (num in numSet) {
            return true
        } else {
            numSet.add(num)
        }
    }

    return false
}
