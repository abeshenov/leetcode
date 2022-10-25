--       date: 2022-10-25
--      title: Check If Two String Arrays are Equivalent
--        url: https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
-- difficulty: easy
--------------------------------------------------------------------------------
module CheckIfTwoStringArraysAreEquivalent
  ( arrayStringsAreEqual
  , tests
  ) where

import           Test.HUnit

arrayStringsAreEqual :: [String] -> [String] -> Bool
arrayStringsAreEqual xs ys = concat xs == concat ys
 
--------------------------------------------------------------------------------
-- Tests
tests :: Test
tests =
  TestList
    [ TestCase $ assertEqual "" True $ arrayStringsAreEqual ["ab", "c"] ["a", "bc"]
    , TestCase $ assertEqual "" False $ arrayStringsAreEqual ["a", "cb"] ["ab", "c"]
    , TestCase $ assertEqual "" True $ arrayStringsAreEqual ["abc", "d", "defg"] ["abcddefg"]
    , TestCase $ assertEqual "" False $ arrayStringsAreEqual ["abc","d","defg"] ["abcddef"]
    ]
