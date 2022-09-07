// 2022-09-07
// https://leetcode.com/problems/construct-string-from-binary-tree/

fun tree2str(root: TreeNode?): String =
    when {
        root == null -> ""
        root.left == null && root.right == null -> root.`val`.toString()
        root.right == null -> "${root.`val`}(${tree2str(root.left)})"
        else -> "${root.`val`}(${tree2str(root.left)})(${tree2str(root.right)})"
    }
