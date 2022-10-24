--       date: 2022-10-23
--      title: Set Mismatch
--        url: https://leetcode.com/problems/set-mismatch/
-- difficulty: easy
--------------------------------------------------------------------------------
module SetMismatch
  ( findErrorNums
  , tests
  ) where

import           Test.HUnit

findErrorNums :: [Int] -> (Int, Int)
findErrorNums nums =
  ( (sumOfSquaresDiff + sumDiff * sumDiff) `div` (2 * sumDiff)
  , (sumOfSquaresDiff - sumDiff * sumDiff) `div` (2 * sumDiff))
  where
    sumDiff = sum nums - n * (n + 1) `div` 2
    sumOfSquaresDiff =
      sum [x ^ 2 | x <- nums] - n * (n + 1) * (2 * n + 1) `div` 6
    n = length nums

--------------------------------------------------------------------------------
-- Tests
tests :: Test
tests =
  TestList
    [ TestCase $
      assertEqual "" (8, 5) $ findErrorNums [1, 2, 3, 4, 8, 6, 7, 8, 9, 10]
    , TestCase $ assertEqual "" (2, 3) $ findErrorNums [1, 2, 2, 4]
    , TestCase $ assertEqual "" (1, 2) $ findErrorNums [1, 1]
    ]
