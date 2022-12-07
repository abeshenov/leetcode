//       date: 2022-12-07
//      title: Range Sum of BST
//        url: https://leetcode.com/problems/range-sum-of-bst/
// difficulty: easy
//------------------------------------------------------------------------------

fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
    if (root == null) {
        return 0
    }

    val sumRoot = if (root.value in low .. high) root.value else 0
    val sumLeft = if (root.value >= low) rangeSumBST(root.left, low, high) else 0
    val sumRight = if (root.value <= high) rangeSumBST(root.right, low, high) else 0

    return sumRoot + sumLeft + sumRight
}
