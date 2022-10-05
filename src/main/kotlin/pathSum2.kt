//       date: 2022-09-24
//      title: Path Sum II
//        url: https://leetcode.com/problems/path-sum-ii/
// difficulty: medium
//------------------------------------------------------------------------------

fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> =
    when {
        root == null -> listOf()
        root.isLeaf() -> if (targetSum == root.value) listOf(listOf(root.value)) else listOf()
        else -> (pathSum(root.left, targetSum - root.value) +
                pathSum(root.right, targetSum - root.value))
            .map { list -> listOf(root.value) + list }
    }

private fun TreeNode.isLeaf(): Boolean =
    left == null && right == null
