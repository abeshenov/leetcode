--       date: 2022-10-04
--      title: Path Sum
--        url: https://leetcode.com/problems/path-sum/
-- difficulty: easy
--------------------------------------------------------------------------------
module PathSum
  ( hasPathSum
  , hasPathSumTests
  ) where

import           BinaryTree
import           Test.HUnit

hasPathSum :: BinaryTree Int -> Int -> Bool
hasPathSum EmptyTree _ = False
hasPathSum (TreeNode val EmptyTree EmptyTree) targetSum = val == targetSum
hasPathSum (TreeNode val left right) targetSum =
  hasPathSum left targetSum' || hasPathSum right targetSum'
  where
    targetSum' = targetSum - val

--------------------------------------------------------------------------------
-- Tests
hasPathSumTests :: Test
hasPathSumTests =
  TestList
    [ TestCase $ assertEqual "" True $ hasPathSum tree1 22
    , TestCase $ assertEqual "" False $ hasPathSum tree2 5
    ]
  where
    tree1 =
      TreeNode
        5
        (TreeNode
           4
           (TreeNode
              11
              (TreeNode 7 EmptyTree EmptyTree)
              (TreeNode 2 EmptyTree EmptyTree))
           EmptyTree)
        (TreeNode
           8
           (TreeNode 13 EmptyTree EmptyTree)
           (TreeNode 4 EmptyTree (TreeNode 1 EmptyTree EmptyTree)))
    tree2 =
      TreeNode
        1
        (TreeNode 2 EmptyTree EmptyTree)
        (TreeNode 3 EmptyTree EmptyTree)
