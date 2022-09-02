// 2022-09-01
// https://leetcode.com/problems/count-good-nodes-in-binary-tree/

fun goodNodes(root: TreeNode?): Int =
    goodNodes_rec(Integer.MIN_VALUE, root)

fun goodNodes_rec(maxOnThePath: Int, root: TreeNode?): Int {
    if (root == null) {
        return 0
    }

    return if (root.`val` < maxOnThePath) {
        goodNodes_rec(maxOnThePath, root.left) + goodNodes_rec(maxOnThePath, root.right)
    } else {
        1 + goodNodes_rec(root.`val`, root.left) + goodNodes_rec(root.`val`, root.right)
    }
}
