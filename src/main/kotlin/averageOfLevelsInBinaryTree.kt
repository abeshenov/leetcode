// 2022-09-02
// https://leetcode.com/problems/average-of-levels-in-binary-tree/

// Functional style :-)

fun averageOfLevels(root: TreeNode?): DoubleArray =
    getLevels(root)
        .map { levelAverage(it) }
        .toList().toDoubleArray()

fun getLevels(root: TreeNode?): Sequence<List<Int>> =
    getLevelsHelper(listOfNotNull(root))

fun getLevelsHelper(level: List<TreeNode>): Sequence<List<Int>> =
    sequence {
        if (level.isNotEmpty()) {
            yield(level.map { it.`val`})
            val nextLevel = level.flatMap { node -> listOf(node.left, node.right) }.filterNotNull()
            yieldAll(getLevelsHelper(nextLevel))
        }
    }

fun levelAverage(level: List<Int>): Double =
    level.map { it.toDouble() }.sum() / level.size
