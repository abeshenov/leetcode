--       date: 2022-11-11
--      title: Remove Duplicates from Sorted Array
--        url: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
-- difficulty: easy
--------------------------------------------------------------------------------
module RemoveDuplicatesFromSortedArray
  ( removeDuplicates
  , tests
  ) where

import           Test.HUnit

removeDuplicates :: Eq a => [a] -> [a]
removeDuplicates [] = []
removeDuplicates [x] = [x]
removeDuplicates (x:y:ys) =
  if x == y
    then rest
    else x : rest
  where
    rest = removeDuplicates (y : ys)

--------------------------------------------------------------------------------
-- Tests
tests :: Test
tests =
  TestList
    [ TestCase $ assertEqual "" [1, 2] $ removeDuplicates [1, 1, 2]
    , TestCase $
      assertEqual "" [0, 1, 2, 3, 4] $
      removeDuplicates [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
    , TestCase $
      assertEqual "" [0, 1, 2, 4, 5, 6, 7, 8, 9, 10] $
      removeDuplicates
        [ 0
        , 1
        , 2
        , 2
        , 2
        , 2
        , 4
        , 4
        , 5
        , 5
        , 5
        , 6
        , 6
        , 6
        , 6
        , 7
        , 7
        , 7
        , 7
        , 8
        , 8
        , 9
        , 9
        , 9
        , 10
        , 10
        , 10
        , 10
        , 10
        , 10
        , 10
        , 10
        ]
    ]
