//       date: 2022-09-14
//      title: Pseudo-Palindromic Paths in a Binary Tree
//        url: https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
// difficulty: medium
//------------------------------------------------------------------------------

fun pseudoPalindromicPaths (root: TreeNode?): Int =
    countHelper(root)

// Note that each path is "pseudopalindromic" iff
// among its digit frequencies at most one is odd.
//
// It will be enough to keep track of parity of frequencies.
// Let's use bit masks:
//
//   0b0000000001 = 1 << 0 :  when frequency of 0 is odd
//   0b0000000010 = 1 << 1 :  when frequency of 1 is odd
//   0b0000000100 = 1 << 2 :  when frequency of 2 is odd
//   ...
//   0b1000000000 = 1 << 9 :  when frequency of 9 is odd
//
// Our accumulator will sum these with bitwise XOR.

private fun countHelper(node: TreeNode?, acc: Int = 0): Int {
    if (node == null) {
        return 0
    }

    val digit = node.`val`
    val newAcc = (1 shl digit) xor acc

    if (node.left == null && node.right == null) {
        return if (isPalindrome(newAcc)) 1 else 0
    }

    return countHelper(node.left, newAcc) + countHelper(node.right, newAcc)
}

private fun isPalindrome(acc: Int): Boolean =
    (acc == 0) || (0..9).any { digit -> acc == 1 shl digit }
