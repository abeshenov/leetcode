// https://leetcode.com/problems/rotate-array/

fun rotate(nums: IntArray, k: Int) {
    // Solution with an extra array is easier

    // In-place idea:
    //   [1,2,3,4,5,6,7], k = 3:

    // Logically split the array:
    //   [1,2,3,4]             [5,6,7]
    //   ^^^^^^^^^             ^^^^^^^
    //   0 .. (nums.size-k-1)  (nums.size-k) .. (nums.size-1)

    // Reverse each part:
    //   [4,3,2,1] [7,6,5]

    // Reverse the whole thing:
    //   [5,6,7,1,2,3,4]

    val kReduced = k % nums.size

    reverse(nums, 0, nums.size - kReduced - 1)
    reverse(nums, nums.size - kReduced, nums.size - 1)
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
