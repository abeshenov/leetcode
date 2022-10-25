--       date: 2022-10-18
--      title: Count and Say
--        url: https://leetcode.com/problems/count-and-say/
-- difficulty: medium
--------------------------------------------------------------------------------
module CountAndSay
  ( countAndSay
  , tests
  ) where

import           Data.List  (group)

import           Test.HUnit

countAndSay :: Int -> String
countAndSay n = countAndSaySeq !! (n - 1)

-- Conway's look and say sequence
-- 1, 11, 21, 1211, 111221, 312211, 13112221, 1113213211, ...
-- https://oeis.org/A005150
countAndSaySeq :: [String]
countAndSaySeq = "1" : map say countAndSaySeq
  where
    say = concatMap sayGroup . group
    sayGroup str = show (length str) ++ [head str]

--------------------------------------------------------------------------------
-- Tests
tests :: Test
tests =
  TestList
    [ TestCase $ assertEqual "" "1" $ countAndSay 1
    , TestCase $ assertEqual "" "11" $ countAndSay 2
    , TestCase $ assertEqual "" "21" $ countAndSay 3
    , TestCase $ assertEqual "" "1211" $ countAndSay 4
    , TestCase $ assertEqual "" "111221" $ countAndSay 5
    , TestCase $ assertEqual "" "312211" $ countAndSay 6
    ]
