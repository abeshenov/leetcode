//       date: 2022-10-08
//      title: 3Sum Closest
//        url: https://leetcode.com/problems/3sum-closest/
// difficulty: medium
//------------------------------------------------------------------------------

import kotlin.math.abs

fun threeSumClosest(nums: IntArray, target: Int): Int {
    val sortedNums = nums.sorted()

    var bestSum = sortedNums[0] + sortedNums[1] + sortedNums.last()

    for (i in 0..nums.lastIndex - 2) {
        var j = i + 1
        var k = nums.lastIndex

        while (j < k) {
            val sum = sortedNums[i] + sortedNums[j] + sortedNums[k]
            if (sum == target) {
                return sum
            }

            bestSum = if (dist(target, sum) < dist(target, bestSum)) sum else bestSum

            if (sum > target) {
                k--
            } else {
                j++
            }
        }
    }

    return bestSum
}

private fun dist(x: Int, y: Int): Int = abs(x - y)
