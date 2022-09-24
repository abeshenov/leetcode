//       date: 2022-09-24
//      title: Path Sum II
//        url: https://leetcode.com/problems/path-sum-ii/
// difficulty: medium
//------------------------------------------------------------------------------

fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> =
    when {
        root == null -> listOf()
        root.isLeaf() -> if (targetSum == root.`val`) listOf(listOf(root.`val`)) else listOf()
        else -> (pathSum(root.left, targetSum - root.`val`) +
                pathSum(root.right, targetSum - root.`val`))
            .map { list -> listOf(root.`val`) + list }
    }

private fun TreeNode.isLeaf(): Boolean =
    left == null && right == null
