--       date: 2022-09-02
--      title: Average of Levels in Binary Tree
--        url: https://leetcode.com/problems/average-of-levels-in-binary-tree/
-- difficulty: easy
--------------------------------------------------------------------------------
module AverageOfLevelsInBinaryTree (averageOfLevels) where

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
