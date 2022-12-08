//       date: 2022-12-08
//      title: Leaf-Similar Trees
//        url: https://leetcode.com/problems/leaf-similar-trees/
// difficulty: easy
//------------------------------------------------------------------------------

fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean =
    leaves(root1) == leaves(root2)

fun leaves(root: TreeNode?): List<Int> =
    when {
        root == null -> listOf()
        root.left == null && root.right == null -> listOf(root.value)
        else -> leaves(root.left) + leaves(root.right)
    }
