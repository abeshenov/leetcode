//       date: 2022-09-18
//      title: Trapping Rain Water
//        url: https://leetcode.com/problems/trapping-rain-water/
// difficulty: hard
//------------------------------------------------------------------------------

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
//
// This is "running reduce"!
//   runningMaximum[0] = height[0]
//   runningMaximum[1] = max(height[0], height[1])
//   runningMaximum[2] = max(height[0], height[1], height[2])
//   ...

fun trap(height: IntArray): Int =
    leftMaximums(height).zip(rightMaximums(height), Math::min).sum() -
            height.sum()

private fun leftMaximums(height: IntArray): List<Int> =
    height.runningReduce(Math::max)

private fun rightMaximums(height: IntArray): List<Int> =
    height.reversed().runningReduce(Math::max).reversed()
