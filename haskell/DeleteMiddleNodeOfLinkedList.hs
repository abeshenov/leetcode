--       date: 2022-10-14
--      title: Delete the Middle Node of a Linked List
--        url: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
-- difficulty: medium
--------------------------------------------------------------------------------
module DeleteMiddleNodeOfLinkedList
  ( deleteMiddle
  , deleteMiddleTests
  ) where

import           Test.HUnit

deleteMiddle :: [a] -> [a]
deleteMiddle xs = take m xs ++ drop (m + 1) xs
  where
    m = length xs `div` 2

--------------------------------------------------------------------------------
-- Tests
deleteMiddleTests :: Test
deleteMiddleTests =
  TestList
    [ TestCase $ assertEqual "" [] $ deleteMiddle [1]
    , TestCase $ assertEqual "" [1] $ deleteMiddle [1, 2]
    , TestCase $ assertEqual "" [1, 3] $ deleteMiddle [1, 2, 3]
    , TestCase $ assertEqual "" [1, 2, 4] $ deleteMiddle [1, 2, 3, 4]
    , TestCase $ assertEqual "" [1, 2, 4, 5] $ deleteMiddle [1, 2, 3, 4, 5]
    , TestCase $
      assertEqual "" [1, 2, 3, 5, 6] $ deleteMiddle [1, 2, 3, 4, 5, 6]
    ]
