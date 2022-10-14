--       date: 2022-10-05
--      title: Add One Row to Tree
--        url: https://leetcode.com/problems/add-one-row-to-tree/
-- difficulty: medium
--------------------------------------------------------------------------------

module AddOneRowToTree
  ( addOneRow
  , tests
  ) where

import           BinaryTree
import           Test.HUnit

addOneRow :: BinaryTree Int -> Int -> Int -> BinaryTree Int
addOneRow EmptyTree _ _ = EmptyTree
addOneRow (TreeNode nodeVal left right) value depth
  | depth == 1 = TreeNode value (TreeNode nodeVal left right) EmptyTree
  | depth == 2 =
    TreeNode
      nodeVal
      (TreeNode value left EmptyTree)
      (TreeNode value EmptyTree right)
  | otherwise =
    TreeNode
      nodeVal
      (addOneRow left value (depth - 1))
      (addOneRow right value (depth - 1))

--------------------------------------------------------------------------------
-- Tests
tests :: Test
tests =
  TestList [TestCase $ assertEqual "" tree1' $ addOneRow tree1 1 3]
  where
    tree1 =
      TreeNode
        4
        (TreeNode
           2
           (TreeNode 3 EmptyTree EmptyTree)
           (TreeNode 1 EmptyTree EmptyTree))
        EmptyTree
    tree1' =
      TreeNode
        4
        (TreeNode
           2
           (TreeNode 1 (TreeNode 3 EmptyTree EmptyTree) EmptyTree)
           (TreeNode 1 EmptyTree (TreeNode 1 EmptyTree EmptyTree)))
        EmptyTree
