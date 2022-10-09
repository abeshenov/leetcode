--       date: 2022-10-08
--      title: 3Sum Closest
--        url: https://leetcode.com/problems/3sum-closest/
-- difficulty: medium
--------------------------------------------------------------------------------
module TwoSum4
  ( findTarget
  , findTargetTests
  ) where

import           BinaryTree
import           Test.HUnit

findTarget :: Int -> BinaryTree Int -> Bool
findTarget target tree = findTarget' target $ treeToList tree

treeToList :: BinaryTree a -> [a]
treeToList EmptyTree               = []
treeToList (TreeNode x left right) = treeToList left ++ [x] ++ treeToList right

findTarget' :: Int -> [Int] -> Bool
findTarget' target [] = False
findTarget' target [_] = False
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
  TestLabel "3Sum Closest" $
  TestList
    [ TestCase $ assertEqual "" True $ findTarget 9 tree
    , TestCase $ assertEqual "" False $ findTarget 28 tree
    ]
  where
    tree =
      TreeNode 5 (TreeNode 3 (leaf 2) (leaf 4)) (TreeNode 6 EmptyTree (leaf 7))
