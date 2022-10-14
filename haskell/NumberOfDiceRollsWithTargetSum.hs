--       date: 2022-10-02
--      title: Number of Dice Rolls With Target Sum
--        url: https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
-- difficulty: medium
--------------------------------------------------------------------------------
module NumberOfDiceRollsWithTargetSum
  ( numRollsToTarget
  , tests
  ) where

import           Data.Array (Array, listArray, (!))
import           Test.HUnit

numRollsToTarget :: Int -> Int -> Int -> Int
numRollsToTarget n k target =
  if n * k < target
    then 0
    else dp n ! target
  where
    sumMod m = foldl (\x y -> (x + y) `mod` m) 0
    -- i is the number of rolled dice, and
    -- dp i is the array indexed by target sum
    dp 1 =
      listArray
        (0, target - n + 1)
        [ if 1 <= i && i <= k
          then 1
          else 0
        | i <- [0 .. target - n + 1]
        ]
    dp i =
      listArray (0, target - n + i) $
      0 :
      [ sumMod
        (10 ^ 9 + 7)
        [ if (s - c) >= 0
          then dp' ! (s - c)
          else 0
        | c <- [1 .. k]
        ]
      | s <- [1 .. target - n + i]
      ]
      where
        dp' = dp (i - 1)

--------------------------------------------------------------------------------
-- Tests
tests :: Test
tests =
  TestList
    [ TestCase $ assertEqual "" 1 $ numRollsToTarget 1 6 3
    , TestCase $ assertEqual "" 6 $ numRollsToTarget 2 6 7
    , TestCase $ assertEqual "" 222616187 $ numRollsToTarget 30 30 500
    ]
