//       date: 2022-09-05
//      title: N-ary Tree Level Order Traversal
//        url: https://leetcode.com/problems/n-ary-tree-level-order-traversal/
// difficulty: medium
//------------------------------------------------------------------------------

fun levelOrder(root: Node?): List<List<Int>> =
    levelOrderHelper(listOfNotNull(root))

private tailrec fun levelOrderHelper(
    level: List<Node>,
    acc: MutableList<List<Int>> = mutableListOf()
): List<List<Int>> =
    if (level.isEmpty()) {
        acc
    } else {
        acc.add(level.map { it.`val` })
        levelOrderHelper(level.flatMap { it.children }.filterNotNull(), acc)
    }
