--       date: 2022-09-14
--      title: Pseudo-Palindromic Paths in a Binary Tree
--        url: https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
-- difficulty: medium
--------------------------------------------------------------------------------
module PseudoPalindromicPathsInBinaryTree
  ( pseudoPalindromicPaths
  , tests
  ) where

import           BinaryTree
import           Data.Bits  (shiftL, xor)
import           Test.HUnit

-- Note that each path is "pseudopalindromic" iff
-- among its digit frequencies at most one is odd.
--
-- It will be enough to keep track of parity of frequencies.
-- Let's use bit masks:
--
--   0b0000000001 = 1 << 0 :  when frequency of 0 is odd
--   0b0000000010 = 1 << 1 :  when frequency of 1 is odd
--   0b0000000100 = 1 << 2 :  when frequency of 2 is odd
--   ...
--   0b1000000000 = 1 << 9 :  when frequency of 9 is odd
--
-- Our accumulator will sum these with bitwise XOR.
pseudoPalindromicPaths :: BinaryTree Int -> Int
pseudoPalindromicPaths root = countHelper root 0

countHelper :: BinaryTree Int -> Int -> Int
countHelper EmptyTree _ = 0
countHelper (TreeNode digit left right) acc =
  if left == EmptyTree && right == EmptyTree
    then if isPalindrome newAcc
           then 1
           else 0
    else countHelper left newAcc + countHelper right newAcc
  where
    newAcc = (1 `shiftL` digit) `xor` acc
    isPalindrome acc = elem acc $ 0 : [1 `shiftL` digit | digit <- [0 .. 9]]

--------------------------------------------------------------------------------
-- Tests
tests :: Test
tests =
  TestList
    [ TestCase $
      assertEqual "" 1 $
      pseudoPalindromicPaths
        (TreeNode
           2
           (TreeNode
              1
              (TreeNode 1 EmptyTree EmptyTree)
              (TreeNode 3 EmptyTree (TreeNode 1 EmptyTree EmptyTree)))
           (TreeNode 1 EmptyTree EmptyTree))
    , TestCase $
      assertEqual "" 2 $
      pseudoPalindromicPaths
        (TreeNode
           2
           (TreeNode
              3
              (TreeNode 3 EmptyTree EmptyTree)
              (TreeNode 1 EmptyTree EmptyTree))
           (TreeNode 1 EmptyTree (TreeNode 1 EmptyTree EmptyTree)))
    ]
