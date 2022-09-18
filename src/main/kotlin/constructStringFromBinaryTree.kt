//       date: 2022-09-07
//      title: Construct String from Binary Tree
//        url: https://leetcode.com/problems/construct-string-from-binary-tree/
// difficulty: easy
//------------------------------------------------------------------------------

fun tree2str(root: TreeNode?): String =
    when {
        root == null -> ""
        root.left == null && root.right == null -> root.`val`.toString()
        root.left != null && root.right == null -> "${root.`val`}(${tree2str(root.left)})"
        else -> "${root.`val`}(${tree2str(root.left)})(${tree2str(root.right)})"
    }
