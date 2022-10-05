//       date: 2022-10-05
//      title: Add One Row to Tree
//        url: https://leetcode.com/problems/add-one-row-to-tree/
// difficulty: medium
//------------------------------------------------------------------------------

fun addOneRow(root: TreeNode?, value: Int, depth: Int): TreeNode? {
    if (root == null || depth < 1) {  // Should not happen!
        return null
    }

    val result = TreeNode()

    when (depth) {
        1 -> {
            result.value = value
            result.left = root
        }
        2 -> {
            result.value = root.value

            val newLeft = TreeNode(value)
            newLeft.left = root.left
            result.left = newLeft

            val newRight = TreeNode(value)
            newRight.right = root.right
            result.right = newRight
        }
        else -> {
            result.value = root.value
            result.left = addOneRow(root.left, value, depth - 1)
            result.right = addOneRow(root.right, value, depth - 1)
        }
    }

    return result
}
