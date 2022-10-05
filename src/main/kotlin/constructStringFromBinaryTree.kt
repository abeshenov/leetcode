//       date: 2022-09-07
//      title: Construct String from Binary Tree
//        url: https://leetcode.com/problems/construct-string-from-binary-tree/
// difficulty: easy
//------------------------------------------------------------------------------

fun tree2str(root: TreeNode?): String =
    when {
        root == null -> ""
        root.left == null && root.right == null -> root.value.toString()
        root.left != null && root.right == null -> "${root.value}(${tree2str(root.left)})"
        else -> "${root.value}(${tree2str(root.left)})(${tree2str(root.right)})"
    }
