// https://leetcode.com/problems/sort-array-by-parity/submissions/

import kotlin.math.absoluteValue

// N.B. Sorting is O(n log n)
fun sortArrayByParityCustomSort(nums: IntArray): IntArray {
    return nums.sortedBy { x: Int -> (x % 2).absoluteValue }
        .toIntArray()
}

fun sortArrayByParityFilter(nums: IntArray): IntArray {
    val evenPart = nums.filter { it % 2 == 0 }
    val oddPart = nums.filter { it % 2 == 1 }
    return (evenPart + oddPart).toIntArray()
}

// Extra space for result
fun sortArrayByParityTwoPass(nums: IntArray): IntArray {
    val result = IntArray(nums.size)

    var i = 0

    for (x in nums) {
        if (x % 2 == 0) {
            result[i] = x
            i++
        }
    }

    for (x in nums) {
        if (x % 2 == 1) {
            result[i] = x
            i++
        }
    }

    return result
}

// In-place, one pass
fun sortArrayByParityTwoPointers(nums: IntArray): IntArray {
    var i = 0
    var j = nums.size - 1

    while (i < j) {
        if (nums[i] % 2 == 0) {
            i++
        } else if (nums[j] % 2 == 1) {
            j--
        } else {
            nums.swap(i, j)
            i++
            j--
        }
    }

    return nums
}

private fun IntArray.swap(i: Int, j: Int) {
    val tmp = this[i]
    this[i] = this[j]
    this[j] = tmp
}
