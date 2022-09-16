// https://leetcode.com/problems/pascals-triangle/

fun generate(numRows: Int): List<List<Int>> =
    generateRec(numRows, listOf(1))
        .toList()

private fun generateRec(numRows: Int, row: List<Int>): Sequence<List<Int>> =
    sequence {
    if (numRows > 0) {
        yield(row)
        yieldAll(generateRec(numRows-1, nextRow(row)))
    }
}

private fun nextRow(row: List<Int>): List<Int> =
    List(row.size + 1) { i -> if (i == 0 || i == row.size) 1 else row[i-1] + row[i] }
