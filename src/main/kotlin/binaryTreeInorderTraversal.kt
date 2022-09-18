//       date: 2022-09-08
//      title: Binary Tree Inorder Traversal
//        url: https://leetcode.com/problems/binary-tree-inorder-traversal/
// difficulty: easy
//------------------------------------------------------------------------------

fun inorderTraversal(root: TreeNode?): List<Int> =
    if (root == null) {
        listOf()
    } else {
        inorderTraversal(root.left) + listOf(root.`val`) + inorderTraversal(root.right)
    }
