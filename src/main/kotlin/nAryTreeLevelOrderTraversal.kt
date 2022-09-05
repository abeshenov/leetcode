// 2022-09-05
// https://leetcode.com/problems/n-ary-tree-level-order-traversal/

fun levelOrder(root: Node?): List<List<Int>> =
    levelOrderHelper(listOfNotNull(root)).toList()

private fun levelOrderHelper(level: List<Node>): Sequence<List<Int>> = sequence {
    if (level.isNotEmpty()) {
        yield(level.map { it.`val` })
        yieldAll(levelOrderHelper(level.flatMap { node -> node.children }.filterNotNull()))
    }
}
