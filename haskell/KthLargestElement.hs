--      title: Kth Largest Element in an Array
--        url: https://leetcode.com/problems/kth-largest-element-in-an-array/
-- difficulty: medium
--------------------------------------------------------------------------------
module KthLargestElement
  ( findKthLargest
  , tests
  ) where

import           Test.HUnit

-- See https://en.wikipedia.org/wiki/Quickselect
findKthLargest :: Ord a => Int -> [a] -> a
findKthLargest k (x:xs)
  | k <= biggerLen = findKthLargest k bigger
  | k > biggerLen + equalLen = findKthLargest (k - biggerLen - equalLen) smaller
  | otherwise = x
  where
    smaller = filter (< x) xs
    equal = filter (== x) (x : xs)
    bigger = filter (> x) xs
    biggerLen = length bigger
    equalLen = length equal

--------------------------------------------------------------------------------
-- Tests
tests :: Test
tests =
  TestList
    [ TestCase $
      assertEqual "" 12 $
      findKthLargest 5 [48, 7, -18, 44, 12, 17, -44, 3, 35, -18]
    , TestCase $
      assertEqual "" 8 $
      findKthLargest
        4
        [6, 7, 8, 5, 0, 9, 7, 8, 8, 8, 0, 0, 5, 0, 9, 2, 9, 1, 4, 0]
    , TestCase $
      assertEqual "" 18 $
      findKthLargest
        10
        [ 25
        , -7
        , 18
        , 40
        , -6
        , -48
        , -17
        , 21
        , -29
        , -3
        , 31
        , -38
        , -48
        , -21
        , -26
        , -17
        , 18
        , 36
        , -7
        , -47
        , -20
        , 12
        , 12
        , -34
        , -15
        , 18
        , -12
        , 45
        , 24
        , -5
        ]
    ]
