//      title: Concatenation of Array
//        url: https://leetcode.com/problems/concatenation-of-array/
// difficulty: easy
//------------------------------------------------------------------------------

fun getConcatenation(nums: IntArray): IntArray {
    val result = IntArray(2 * nums.size)

    nums.withIndex()
        .forEach {
            result[it.index] = it.value
            result[it.index + nums.size] = it.value
        }

    return result
}
