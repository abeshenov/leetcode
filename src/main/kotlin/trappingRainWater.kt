// 2022-09-18
// https://leetcode.com/problems/trapping-rain-water/submissions/

// Note that an element height[i] will trap
// min(max(height[0..i]), max(height[i..])) - height[i]
//
//        ▓
//    ▓░░░▓▓░▓
//  ▓░▓▓░▓▓▓▓▓▓
// ▔▔▔▔▔▔▔▔▔▔▔▔▔

private fun trapInefficient(height: IntArray): Int =
    height.indices.sumOf { i ->
        Math.min(
            height.slice(0..i).max(),
            height.slice(i..height.lastIndex).max()
        ) - height[i]
    }

private fun List<Int>.max(): Int =
    if (isEmpty()) 0 else this.reduce(Math::max)

//------------------------------------------------------------------------------

// To optimize this solution, we need a better way to calculate the arrays
//   leftMaximums  := height.slice(0..i).max()
//   rightMaximums := height.slice(i..height.lastIndex).max()

fun trap(height: IntArray): Int {
    val leftMaximums = leftMaximums(height)
    val rightMaximums = rightMaximums(height)

    return height.indices.sumOf { i ->
        Math.min(leftMaximums[i], rightMaximums[i]) - height[i]
    }
}

// This is "running reduce"!
// runningMaximum[0] = height[0]
// runningMaximum[1] = max(height[0], height[1])
// runningMaximum[2] = max(height[0], height[1], height[2])
// ...

private fun leftMaximums(height: IntArray): List<Int> =
    height.runningReduce(Math::max)

private fun rightMaximums(height: IntArray): List<Int> =
    height.reversed().runningReduce(Math::max).reversed()
