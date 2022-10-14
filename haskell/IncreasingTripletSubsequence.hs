--       date: 2022-10-11
--      title: Increasing Triplet Subsequence
--        url: https://leetcode.com/problems/increasing-triplet-subsequence/
-- difficulty: medium
--------------------------------------------------------------------------------
module IncreasingTripletSubsequence
  ( increasingTriplet
  , tests
  ) where

import           Test.HUnit

maxIntValue = 2 ^ 31 - 1 :: Int

increasingTriplet :: [Int] -> Bool
increasingTriplet = increasingTriplet' (maxIntValue, maxIntValue)
  where
    increasingTriplet' _ [] = False
    increasingTriplet' (first, second) (third:tail)
      | third > first && third > second = True
      | third <= first = increasingTriplet' (third, second) tail
      | otherwise = increasingTriplet' (first, third) tail -- first < third <= second

--------------------------------------------------------------------------------
-- Tests
tests :: Test
tests =
  TestList
    [ TestCase $ assertEqual "" True $ increasingTriplet [3, 1, 4, 2, 5]
    , TestCase $ assertEqual "" True $ increasingTriplet [4, 2, 5, 1, 6, 3]
    , TestCase $ assertEqual "" True $ increasingTriplet [7, 5, 1, 3, 6, 2, 4]
    , TestCase $
      assertEqual "" True $ increasingTriplet [5, 4, 7, 1, 6, 2, 8, 3]
    , TestCase $
      assertEqual "" True $ increasingTriplet [6, 1, 8, 3, 4, 7, 2, 5, 9]
    , TestCase $ assertEqual "" False $ increasingTriplet [1, 5, 4, 3, 2]
    , TestCase $ assertEqual "" False $ increasingTriplet [2, 1, 6, 5, 4, 3]
    , TestCase $ assertEqual "" False $ increasingTriplet [3, 7, 6, 5, 2, 1, 4]
    , TestCase $
      assertEqual "" False $ increasingTriplet [5, 8, 7, 3, 6, 2, 1, 4]
    , TestCase $
      assertEqual "" False $ increasingTriplet [4, 9, 8, 7, 6, 3, 2, 1, 5]
    ]
