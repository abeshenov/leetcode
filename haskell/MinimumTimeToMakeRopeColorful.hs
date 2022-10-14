--       date: 2022-10-03
--      title: Minimum Time to Make Rope Colorful
--        url: https://leetcode.com/problems/minimum-time-to-make-rope-colorful/
-- difficulty: medium
--------------------------------------------------------------------------------
module MinimumTimeToMakeRopeColorful
  ( minCost
  , tests
  ) where

import           Data.List  (groupBy)
import           Test.HUnit

minCost :: [Char] -> [Int] -> Int
minCost colors neededTime =
  sum $ map minCostForGroup $ splitInGroups $ zip colors neededTime

splitInGroups :: [(Char, Int)] -> [[(Char, Int)]]
splitInGroups = groupBy (\(x, _) (y, _) -> x == y)

-- Min cost for a group of balloons having the same color
minCostForGroup :: [(Char, Int)] -> Int
minCostForGroup balloons = totalCost - maxCost
  where
    totalCost = sum $ map snd balloons
    maxCost = maximum $ map snd balloons

--------------------------------------------------------------------------------
-- Tests
tests :: Test
tests =
  TestList
    [ TestCase $ assertEqual "" 2 $ minCost "aabaa" [1, 2, 3, 4, 1]
    , TestCase $ assertEqual "" 0 $ minCost "abc" [1, 2, 3]
    , TestCase $ assertEqual "" 3 $ minCost "abaac" [1, 2, 3, 4, 5]
    , TestCase $
      assertEqual "" 24 $
      minCost
        "bbbbabaacabacccabccb"
        [1, 3, 6, 3, 9, 8, 4, 9, 9, 3, 6, 7, 8, 4, 9, 1, 9, 1, 1, 5]
    ]
