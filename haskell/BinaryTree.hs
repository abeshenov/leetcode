module BinaryTree where

data BinaryTree a
  = EmptyTree
  | TreeNode a (BinaryTree a) (BinaryTree a)
  deriving (Show)
