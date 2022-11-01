//       date: 2022-10-31
//      title: Toeplitz Matrix
//        url: https://leetcode.com/problems/toeplitz-matrix/
// difficulty: easy
//------------------------------------------------------------------------------

fun isToeplitzMatrix(matrix: Array<IntArray>): Boolean {
    for (i in 1 until matrix.size) {
        for (j in 1 until matrix[0].size) {
            if (matrix[i][j] != matrix[i-1][j-1]) {
                return false
            }
        }
    }

    return true
}
