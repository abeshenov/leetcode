//       date: 2022-09-02
//      title: Average of Levels in Binary Tree
//        url: https://leetcode.com/problems/average-of-levels-in-binary-tree/
// difficulty: easy
//------------------------------------------------------------------------------

fun averageOfLevels(root: TreeNode?): DoubleArray =
    getLevels(root)
        .map { levelAverage(it) }
        .toList().toDoubleArray()

private fun getLevels(root: TreeNode?): Sequence<List<Int>> =
    getLevelsHelper(listOfNotNull(root))

private fun getLevelsHelper(level: List<TreeNode>): Sequence<List<Int>> =
    sequence {
        if (level.isNotEmpty()) {
            yield(level.map { it.value})
            val nextLevel = level.flatMap { node -> listOf(node.left, node.right) }.filterNotNull()
            yieldAll(getLevelsHelper(nextLevel))
        }
    }

private fun levelAverage(level: List<Int>): Double =
    level.map { it.toDouble() }.sum() / level.size
