//       date: 2022-11-23
//      title: Valid Sudoku
//        url: https://leetcode.com/problems/valid-sudoku/
// difficulty: medium
//------------------------------------------------------------------------------

fun isValidSudoku(board: Array<CharArray>): Boolean =
    isValidRows(board) && isValidColumns(board) && isValidBlocks(board)

private fun isValidRows(board: Array<CharArray>): Boolean =
    board.all { isValidRow(it) }

private fun isValidColumns(board: Array<CharArray>): Boolean =
    isValidRows(transpose(board))

private fun isValidBlocks(board: Array<CharArray>): Boolean =
    board.indices.step(3).all { i ->
        board.indices.step(3).all { j ->
            isValidBlock(extractBlock(board, i, j))
        }
    }

private fun transpose(board: Array<CharArray>): Array<CharArray> =
    Array (9) { i -> CharArray(9) { j -> board[j][i] } }

private fun extractBlock(board: Array<CharArray>, i: Int, j: Int): Array<CharArray> =
    Array(3) { di -> CharArray(3) { dj -> board[i + di][j + dj] } }

private fun isValidRow(row: CharArray): Boolean =
    hasUniqueCharacters(row.filter { it.isDigit() })

private fun isValidBlock(block: Array<CharArray>): Boolean =
    isValidRow(block.flatMap { it.asList() }.toCharArray())

private fun hasUniqueCharacters(str: List<Char>): Boolean {
    val chars: MutableSet<Char> = mutableSetOf()

    for (char in str) {
        if (chars.contains(char)) {
            return false
        } else {
            chars.add(char)
        }
    }

    return true
}
