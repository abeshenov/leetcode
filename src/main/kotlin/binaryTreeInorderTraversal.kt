//       date: 2022-09-08
//      title: Binary Tree Inorder Traversal
//        url: https://leetcode.com/problems/binary-tree-inorder-traversal/
// difficulty: easy
//------------------------------------------------------------------------------

import java.util.Stack

fun inorderTraversal(root: TreeNode?): List<Int> =
    if (root == null) {
        listOf()
    } else {
        inorderTraversal(root.left) + listOf(root.value) + inorderTraversal(root.right)
    }

fun inorderTraversalStack(root: TreeNode?): List<Int> {
    val result: MutableList<Int> = mutableListOf()
    val stack: Stack<TreeNode> = Stack()
    var ptr: TreeNode? = root

    while (ptr != null || stack.isNotEmpty()) {
        if (ptr != null) {
            stack.push(ptr)
            ptr = ptr.left
        } else {
            ptr = stack.pop()
            result.add(ptr.value)
            ptr = ptr.right
        }
    }

    return result
}
