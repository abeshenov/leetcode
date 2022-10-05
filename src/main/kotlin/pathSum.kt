//       date: 2022-10-04
//      title: Path Sum
//        url: https://leetcode.com/problems/path-sum/
// difficulty: easy
//------------------------------------------------------------------------------

fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean =
    root != null &&
            ((root.left == null && root.right == null && targetSum == root.value) ||
                    hasPathSum(root.left, targetSum - root.value) ||
                    hasPathSum(root.right, targetSum - root.value))
