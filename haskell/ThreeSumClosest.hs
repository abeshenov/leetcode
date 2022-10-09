--       date: 2022-10-08
--      title: 3Sum Closest
--        url: https://leetcode.com/problems/3sum-closest/
-- difficulty: medium
--------------------------------------------------------------------------------
module ThreeSumClosest
  ( threeSumClosest
  , threeSumClosestTests
  ) where

import           Data.List  (tails)
import           Data.Sort
import           Test.HUnit

threeSumClosest :: [Int] -> Int -> Int
threeSumClosest nums target =
  minWith (dist target) $
  map (threeSumClosest' target) $ dropLast 3 $ tails $ sort nums

minWith :: Ord b => (a -> b) -> [a] -> a
minWith f [] = error "List can't be empty"
minWith f [x] = x
minWith f (x:y:zs) =
  if f x < f y
    then minWith f (x : zs)
    else minWith f (y : zs)

dist :: Num a => a -> a -> a
dist x y = abs (x - y)

dropLast :: Int -> [a] -> [a]
dropLast n = reverse . drop n . reverse

threeSumClosest' :: Int -> [Int] -> Int
threeSumClosest' target (firstElem:rest) =
  threeSumClosest'' target (firstElem : rest) bestSum
  where
    secondElem:_ = rest
    thirdElem = last rest
    bestSum = firstElem + secondElem + thirdElem

threeSumClosest'' :: Int -> [Int] -> Int -> Int
threeSumClosest'' _ [] bestSum = bestSum
threeSumClosest'' _ [_] bestSum = bestSum
threeSumClosest'' _ [_, _] bestSum = bestSum
threeSumClosest'' target (firstElem:rest) bestSum =
  if s == target
    then s
    else threeSumClosest'' target (firstElem : rest') bestSum'
  where
    secondElem:_ = rest
    thirdElem = last rest
    s = firstElem + secondElem + thirdElem
    bestSum' = minWith (dist target) [s, bestSum]
    rest' =
      if s > target
        then init rest
        else tail rest

--------------------------------------------------------------------------------
-- Tests
threeSumClosestTests :: Test
threeSumClosestTests =
  TestList
    [ TestCase $ assertEqual "" 2 $ threeSumClosest [-1, 2, 1, -4] 1
    , TestCase $
      assertEqual "" 193 $
      threeSumClosest [49, 57, 68, 43, 95, 6, 74, 57, 68, 66] 193
    , TestCase $
      assertEqual "" 120 $
      threeSumClosest
        [ 40
        , 35
        , 0
        , 35
        , 40
        , 35
        , 25
        , 10
        , 15
        , 15
        , 20
        , 25
        , 35
        , 30
        , 30
        , 30
        , 25
        , 5
        , 40
        , 30
        ]
        123
    ]
