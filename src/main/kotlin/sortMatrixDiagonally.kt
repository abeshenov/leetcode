// https://leetcode.com/problems/sort-the-matrix-diagonally/

fun diagonalSort(mat: Array<IntArray>): Array<IntArray> {
    val rows = mat.size
    val columns = mat[0].size

    for (row in 0 until rows) {
        val diagonal: IntArray = getDiagonal(mat, row, 0)
        diagonal.sort()
        setDiagonal(mat, row, 0, diagonal)
    }

    for (column in 1 until columns) {
        val diagonal: IntArray = getDiagonal(mat, 0, column)
        diagonal.sort()
        setDiagonal(mat, 0, column, diagonal)
    }

    return mat
}

fun getDiagonal(mat: Array<IntArray>, startRow: Int, startColumn: Int): IntArray {
    val rows = mat.size
    val columns = mat[0].size
    val diagonalLength = Math.min(rows - startRow, columns - startColumn)

    val diagonal = IntArray(diagonalLength)

    var i = startRow
    var j = startColumn
    var k = 0

    while (i < rows && j < columns) {
        diagonal[k] = mat[i][j]

        i++
        j++
        k++
    }

    return diagonal
}

fun setDiagonal(mat: Array<IntArray>, startRow: Int, startColumn: Int, diagonal: IntArray) {
    val rows = mat.size
    val columns = mat[0].size

    var i = startRow
    var j = startColumn
    var k = 0

    while (i < rows && j < columns && k < diagonal.size) {
        mat[i][j] = diagonal[k]

        i++
        j++
        k++
    }
}
