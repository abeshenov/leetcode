//       date: 2022-09-06
//      title: Binary Tree Pruning
//        url: https://leetcode.com/problems/binary-tree-pruning/
// difficulty: medium
//------------------------------------------------------------------------------

fun pruneTree(root: TreeNode?): TreeNode? {
    if (root == null || !containsOne(root)) {
        return null
    }

    val result = TreeNode(root.`val`)
    result.left = pruneTree(root.left)
    result.right = pruneTree(root.right)

    return result
}

private fun containsOne(root: TreeNode?): Boolean =
    root != null &&
            (root.`val` == 1 || containsOne(root.left) || containsOne(root.right))


// In-place version, to be used as
//   pruneTree(root) = if (inplacePruneHelper(root)) root else null
private fun inplacePruneHelper(root: TreeNode?): Boolean {
    if (root == null) {
        return false
    }

    val leftBranchHasOne = inplacePruneHelper(root.left)
    val rightBranchHasOne = inplacePruneHelper(root.right)

    if (!leftBranchHasOne) {
        root.left = null
    }

    if (!rightBranchHasOne) {
        root.right = null
    }

    return root.`val` == 1 || leftBranchHasOne || rightBranchHasOne
}
