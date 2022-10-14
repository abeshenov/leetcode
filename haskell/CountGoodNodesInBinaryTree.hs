--       date: 2022-09-01
--      title: Count Good Nodes in Binary Tree
--        url: https://leetcode.com/problems/count-good-nodes-in-binary-tree/
-- difficulty: medium
--------------------------------------------------------------------------------
module CountGoodNodesInBinaryTree
  ( goodNodes
  , tests
  ) where

import           BinaryTree
import           Test.HUnit

goodNodes :: BinaryTree Int -> Int
goodNodes EmptyTree = 0
goodNodes (TreeNode val left right) =
  1 + goodNodes' val left + goodNodes' val right
  where
    goodNodes' maxOnThePath EmptyTree = 0
    goodNodes' maxOnThePath (TreeNode val left right) =
      if val < maxOnThePath
        then goodNodes' maxOnThePath left + goodNodes' maxOnThePath right
        else 1 + goodNodes' val left + goodNodes' val right

--------------------------------------------------------------------------------
-- Tests
tests :: Test
tests =
  TestList
    [ TestCase $
      assertEqual "" 4 $
      goodNodes
        (TreeNode
           3
           (TreeNode 1 (TreeNode 3 EmptyTree EmptyTree) EmptyTree)
           (TreeNode
              4
              (TreeNode 1 EmptyTree EmptyTree)
              (TreeNode 5 EmptyTree EmptyTree)))
    , TestCase $
      assertEqual "" 3 $
      goodNodes
        (TreeNode
           3
           (TreeNode
              3
              (TreeNode 4 EmptyTree EmptyTree)
              (TreeNode 2 EmptyTree EmptyTree))
           EmptyTree)
    , TestCase $ assertEqual "" 1 $ goodNodes (TreeNode 1 EmptyTree EmptyTree)
    ]
