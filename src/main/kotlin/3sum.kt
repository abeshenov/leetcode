//      title: 3Sum
//        url: https://leetcode.com/problems/3sum/
// difficulty: medium
//------------------------------------------------------------------------------


fun threeSum(nums: IntArray): List<List<Int>> {
    nums.sort()
    val result: MutableList<List<Int>> = mutableListOf()

    for (i in 0..nums.size - 3) {
        if (nums[i] > 0) {  // 0 < nums[i] < nums[j] < nums[k])
            break
        }
        if (i > 0 && nums[i] == nums[i - 1]) {  // we skip duplicates
            continue
        }

        var j = i + 1
        var k = nums.lastIndex

        while (j < k) {
            val s = nums[i] + nums[j] + nums[k]

            if (s == 0) {
                result.add(listOf(nums[i], nums[j], nums[k]))
                j++
                k--
                while (j < k && nums[j] == nums[j - 1]) {
                    j++
                }
                while (j < k && nums[k] == nums[k + 1]) {
                    k--
                }
            } else if (s < 0) {
                j++
                while (j < k && nums[j] == nums[j - 1]) {
                    j++
                }
            } else {
                k--
                while (j < k && nums[k] == nums[k + 1]) {
                    k--
                }
            }
        }
    }

    return result
}
