--       date: 2022-10-09
--      title: Two Sum IV - Input is a BST
--        url: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
-- difficulty: easy
--------------------------------------------------------------------------------
module TwoSum4
  ( findTarget
  , findTargetTests
  ) where

import           BinaryTree
import           Test.HUnit

findTarget :: Int -> BinaryTree Int -> Bool
findTarget target tree = findTarget' target $ searchTreeToList tree

findTarget' :: Int -> [Int] -> Bool
findTarget' _ [] = False
findTarget' _ [_] = False
findTarget' target xs = s == target || findTarget' target xs'
  where
    s = head xs + last xs
    xs' =
      if s > target
        then init xs
        else tail xs

--------------------------------------------------------------------------------
-- Tests
findTargetTests :: Test
findTargetTests =
  TestList
    [ TestCase $ assertEqual "" True $ findTarget 9 tree1
    , TestCase $ assertEqual "" False $ findTarget 28 tree1
    , TestCase $ assertEqual "" True $ findTarget 60 tree2
    , TestCase $ assertEqual "" True $ findTarget 180 tree2
    , TestCase $ assertEqual "" False $ findTarget 130 tree2
    , TestCase $ assertEqual "" False $ findTarget 169 tree2
    ]
  where
    tree1 =
      TreeNode 5 (TreeNode 3 (leaf 2) (leaf 4)) (TreeNode 6 EmptyTree (leaf 7))
    tree2 =
        listToSearchTree [14, 17, 43, 50, 51, 53, 67, 89, 91, 94]
