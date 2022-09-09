// 2022-09-08
// https://leetcode.com/problems/binary-tree-inorder-traversal/

fun inorderTraversal(root: TreeNode?): List<Int> =
    if (root == null) {
        listOf()
    } else {
        inorderTraversal(root.left) + listOf(root.`val`) + inorderTraversal(root.right)
    }
