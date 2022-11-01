//       date: 2022-11-01
//      title: Where Will the Ball Fall
//        url: https://leetcode.com/problems/where-will-the-ball-fall/
// difficulty: medium
//------------------------------------------------------------------------------

fun findBall(grid: Array<IntArray>): IntArray =
    transpose(grid.fold(IntArray(grid[0].size) { it }, ::nextPosition))

// I find it more logical to use the following encoding for ball positions:
// let ballPosition[i] be the ball # in the i-th position.
// If there is no ball, we set ballPosition[i] = -1.

// Thus The initial position of balls is [0, 1, 2, ..., n-1]

// Consider a ball in position i.
//   - If boards (i, i+1) are |\|\| (i.e (+1, +1)), the ball goes to i+1.
//   - If boards (i-1, i) are |/|/| (i.e (-1, -1)), the ball goes to i-1.
//   - Otherwise, the ball gets stuck.

// To see this, consider all possible configurations
//   |\|\|\|, |\|\|/|, |\|/|\|, |\|/|/|, |/|\|\|, |/|\|/|, |/|/|\|, |/|/|/|
// with the ball in the middle.

private fun nextPosition(ballPosition: IntArray, boards: IntArray): IntArray {
    val result = IntArray(ballPosition.size) { -1 }

    for (i in ballPosition.indices) {
        if (ballPosition[i] == -1) {
            continue
        }

        if (i < ballPosition.lastIndex && boards[i] == +1 && boards[i + 1] == +1) {
            result[i + 1] = ballPosition[i]
        }

        if (i > 0 && boards[i] == -1 && boards[i - 1] == -1) {
            result[i - 1] = ballPosition[i]
        }
    }

    return result
}

// This is to convert our encoding of positions to the one required by the problem
private fun transpose(ballPosition: IntArray): IntArray {
    val result = IntArray(ballPosition.size) { -1 }

    for (i in ballPosition.indices) {
        if (ballPosition[i] != -1) {
            result[ballPosition[i]] = i
        }
    }

    return result
}
