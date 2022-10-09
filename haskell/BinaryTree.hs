module BinaryTree where

data BinaryTree a
  = EmptyTree
  | TreeNode a (BinaryTree a) (BinaryTree a)
  deriving (Eq, Show)

leaf :: a -> BinaryTree a
leaf x = TreeNode x EmptyTree EmptyTree
