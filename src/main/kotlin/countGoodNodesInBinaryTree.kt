// 2022-09-01
// https://leetcode.com/problems/count-good-nodes-in-binary-tree/

fun goodNodes(root: TreeNode?): Int =
    goodNodesRec(Integer.MIN_VALUE, root)

private fun goodNodesRec(maxOnThePath: Int, root: TreeNode?): Int {
    if (root == null) {
        return 0
    }

    return if (root.`val` < maxOnThePath) {
        goodNodesRec(maxOnThePath, root.left) + goodNodesRec(maxOnThePath, root.right)
    } else {
        1 + goodNodesRec(root.`val`, root.left) + goodNodesRec(root.`val`, root.right)
    }
}
