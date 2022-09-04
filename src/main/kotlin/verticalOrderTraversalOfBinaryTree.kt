// 2022-09-04
// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

import java.util.TreeMap

// Idea:
//   1. Build a map column |-> row |-> list of values.
//   2. For each column and row, sort the corresponding values.
// Possible optimizations left out for simplicity:
//   a. Instead of TreeMaps, use arrays or other simpler structures.
//   b. Instead of sorting the values separately, use PriorityQueue<Int>.

fun verticalTraversal(root: TreeNode?): List<List<Int>> =
    valueMap(root).values.map { columnMap -> columnMap.values.flatMap { it.sorted() } }

private fun valueMap(root: TreeNode?): TreeMap<Int, TreeMap<Int, MutableList<Int>>> {
    val valuesByColumn: TreeMap<Int, TreeMap<Int, MutableList<Int>>> = TreeMap()
    recursiveTraversalHelper(valuesByColumn, root)
    return valuesByColumn
}

private fun recursiveTraversalHelper(
    valuesByColumn: TreeMap<Int, TreeMap<Int, MutableList<Int>>>,
    root: TreeNode?,
    row: Int = 0,
    col: Int = 0
) {
    if (root == null) {
        return
    }

    if (valuesByColumn[col] == null) {
        valuesByColumn[col] = TreeMap()
    }

    if (valuesByColumn[col]!![row] == null) {
        valuesByColumn[col]!![row] = mutableListOf()
    }

    valuesByColumn[col]!![row]!!.add(root.`val`)

    recursiveTraversalHelper(valuesByColumn, root.left, row + 1, col - 1)
    recursiveTraversalHelper(valuesByColumn, root.right, row + 1, col + 1)
}
