--       date: 2022-09-29
--      title: Find k closest elements
--        url: https://leetcode.com/problems/find-k-closest-elements/
-- difficulty: medium
--------------------------------------------------------------------------------
module FindKClosestElements
  ( findClosestElements
  , findClosestElementsTests
  ) where

import           Data.Array    (Array, array, bounds, ixmap, listArray, (!))
import           Data.Foldable (toList)
import           Test.HUnit

findClosestElements :: [Int] -> Int -> Int -> [Int]
findClosestElements nums k x = toList $ ixmap (left, left + k - 1) id arr
  where
    arr = listArray (0, length nums - 1) nums
    left = closestBinSearch arr k x

closestBinSearch :: Array Int Int -> Int -> Int -> Int
closestBinSearch arr k x =
  closestBinSearch' arr k x lowerBound (upperBound - k + 1)
  where
    (lowerBound, upperBound) = bounds arr

-- Binary search in Haskell
closestBinSearch' :: Array Int Int -> Int -> Int -> Int -> Int -> Int
closestBinSearch' arr k x left right
  | left >= right = left
  | x - (arr ! mid) > (arr ! (mid + k)) - x =
    closestBinSearch' arr k x (mid + 1) right
  | otherwise = closestBinSearch' arr k x left mid
  where
    mid = (left + right) `div` 2

--------------------------------------------------------------------------------
-- Tests
findClosestElementsTests :: Test
findClosestElementsTests =
  TestList
    [ TestCase $
      assertEqual "" [1, 2, 3, 4] $ findClosestElements [1, 2, 3, 4, 5] 4 3
    , TestCase $
      assertEqual "" [1, 2, 3, 4] $ findClosestElements [1, 2, 3, 4, 5] 4 (-1)
    , TestCase $
      assertEqual "" [3, 6, 8, 8, 9] $
      findClosestElements [0, 1, 2, 2, 2, 3, 6, 8, 8, 9] 5 9
    , TestCase $ assertEqual "" [8, 10] $ findClosestElements [3, 5, 8, 10] 2 15
    , TestCase $
      assertEqual "" [10] $ findClosestElements [1, 1, 1, 10, 10, 10] 1 9
    ]
