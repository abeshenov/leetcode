// https://leetcode.com/problems/rotate-image/

fun rotate(matrix: Array<IntArray>) {
    // Transpose and flip:

    // 1 2 3       1 4 7       7 4 1
    // 4 5 6  -->  2 5 8  -->  8 5 2
    // 7 8 9       3 6 9       9 6 3

    transpose(matrix)
    flip(matrix)
}

private fun transpose(matrix: Array<IntArray>) {
    for (i in matrix.indices) {
        for (j in 0 until i) {
            val tmp = matrix[j][i]
            matrix[j][i] = matrix[i][j]
            matrix[i][j] = tmp
        }
    }
}

private fun flip(matrix: Array<IntArray>) {
    for (i in matrix.indices) {
        var j = 0
        var k = matrix[i].lastIndex
        while (j < k) {
            val tmp = matrix[i][j]
            matrix[i][j] = matrix[i][k]
            matrix[i][k] = tmp
            j += 1
            k -= 1
        }
    }
}
