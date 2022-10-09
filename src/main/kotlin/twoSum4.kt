//       date: 2022-10-09
//      title: Two Sum IV - Input is a BST
//        url: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
// difficulty: easy
//------------------------------------------------------------------------------

fun findTarget(root: TreeNode?, k: Int): Boolean =
    findTarget(k, treeToList(root))

private fun findTarget(target: Int, numbers: List<Int>): Boolean {
    var i = 0
    var j = numbers.lastIndex

    while (i < j) {
        val sum = numbers[i] + numbers[j]
        if (sum == target) {
            return true
        }

        if (sum <= target) {
            i++
        } else {
            j--
        }
    }

    return false
}

private fun treeToList(root: TreeNode?): List<Int> =
    if (root == null) {
        listOf()
    } else {
        treeToList(root.left) + root.value + treeToList(root.right)
    }
