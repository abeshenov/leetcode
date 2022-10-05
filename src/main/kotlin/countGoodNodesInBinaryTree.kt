//       date: 2022-09-01
//      title: Count Good Nodes in Binary Tree
//        url: https://leetcode.com/problems/count-good-nodes-in-binary-tree/
// difficulty: medium
//------------------------------------------------------------------------------

fun goodNodes(root: TreeNode?): Int =
    goodNodesRec(Integer.MIN_VALUE, root)

private fun goodNodesRec(maxOnThePath: Int, root: TreeNode?): Int =
    if (root == null) {
        0
    } else if (root.value < maxOnThePath) {
        goodNodesRec(maxOnThePath, root.left) + goodNodesRec(maxOnThePath, root.right)
    } else {
        1 + goodNodesRec(root.value, root.left) + goodNodesRec(root.value, root.right)
    }
