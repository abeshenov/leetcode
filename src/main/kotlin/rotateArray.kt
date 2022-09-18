//      title: Rotate Array
//        url: https://leetcode.com/problems/rotate-array/
// difficulty: medium
//------------------------------------------------------------------------------

// Solution with an extra array is easier

// In-place idea:
//   [1,2,3,4,5,6,7], k = 3:

// Logically split the array:
//   [1,2,3,4]             [5,6,7]
//   ^^^^^^^^^             ^^^^^^^
//   size (nums.size-k)    size k

// Reverse each part:
//   [4,3,2,1] [7,6,5]

// Reverse the whole thing:
//   [5,6,7,1,2,3,4]
fun rotate(nums: IntArray, k: Int) {
    val kReduced = k % nums.size

    reverse(nums, 0, nums.lastIndex - kReduced)
    reverse(nums, nums.size - kReduced, nums.lastIndex)
    reverse(nums)
}

private fun reverse(nums: IntArray, startPos: Int = 0, endPos: Int = nums.lastIndex) {
    var i = startPos
    var j = endPos

    while (i < j) {
        val tmp = nums[i]
        nums[i] = nums[j]
        nums[j] = tmp
        i++
        j--
    }
}
