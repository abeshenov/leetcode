// 2022-09-05
// https://leetcode.com/problems/n-ary-tree-level-order-traversal/

fun levelOrder(root: Node?): List<List<Int>> =
    levelOrderHelper(listOfNotNull(root))

private tailrec fun levelOrderHelper(level: List<Node>, acc: MutableList<List<Int>> = mutableListOf()): List<List<Int>> =
    if (level.isNotEmpty()) {
        acc.add(level.map { it.`val` })
        levelOrderHelper(level.flatMap { it.children }.filterNotNull(), acc)
    } else {
        acc
    }
