--       date: 2022-09-02
--      title: Average of Levels in Binary Tree
--        url: https://leetcode.com/problems/average-of-levels-in-binary-tree/
-- difficulty: easy
--------------------------------------------------------------------------------

import           BinaryTree

averageOfLevels :: BinaryTree Int -> [Double]
averageOfLevels = map average . treeLevels

treeLevels :: BinaryTree a -> [[a]]
treeLevels tree = treeLevels' $ filter isNotEmpty [tree]

treeLevels' :: [BinaryTree a] -> [[a]]
treeLevels' [] = []
treeLevels' treeNodes =
  map treeNodeValue treeNodes : treeLevels' (concatMap nextLevel treeNodes)
  where
    nextLevel EmptyTree               = []
    nextLevel (TreeNode _ left right) = filter isNotEmpty [left, right]

isNotEmpty :: BinaryTree a -> Bool
isNotEmpty EmptyTree   = False
isNotEmpty TreeNode {} = True

treeNodeValue :: BinaryTree a -> a
treeNodeValue (TreeNode x _ _) = x

average :: [Int] -> Double
average xs = fromIntegral (sum xs) / fromIntegral (length xs)

{-
import Control.Exception.Base (assert)

testTree1 = TreeNode 3 (TreeNode 9 EmptyTree EmptyTree) (TreeNode 20 (TreeNode 15 EmptyTree EmptyTree) (TreeNode 7 EmptyTree EmptyTree))
testTree2 = TreeNode 3 (TreeNode 9 (TreeNode 15 EmptyTree EmptyTree) (TreeNode 7 EmptyTree EmptyTree))  (TreeNode 20 EmptyTree EmptyTree)

assert ([3.0,14.5,11.0] == averageOfLevels testTree1) ()
assert ([3.0,14.5,11.0] == averageOfLevels testTree2) ()
-}
