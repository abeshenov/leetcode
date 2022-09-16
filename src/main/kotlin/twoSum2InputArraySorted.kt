// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

fun twoSumSorted(numbers: IntArray, target: Int): IntArray {
    var left = 0
    var right = numbers.size - 1

    while (left < right) {
        val sum = numbers[left] + numbers[right]
        if (sum > target) { right-- }
        else if (sum < target) { left++ }
        else { return intArrayOf(left+1, right+1) }
    }

    return intArrayOf(-1, -1)
}
