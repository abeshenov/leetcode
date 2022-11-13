--       date: 2022-11-13
--      title: Reverse Words in a String
--        url: https://leetcode.com/problems/reverse-words-in-a-string/
-- difficulty: easy
--------------------------------------------------------------------------------
module ReverseWordsInString
  ( reverseWords
  , tests
  ) where

import           Test.HUnit

reverseWords :: String -> String
reverseWords = unwords . reverse . words

--------------------------------------------------------------------------------
-- Tests
tests :: Test
tests =
  TestList
    [ TestCase $
      assertEqual "" "blue is sky the" $ reverseWords "the sky is blue"
    , TestCase $ assertEqual "" "world hello" $ reverseWords "  hello world  "
    , TestCase $
      assertEqual "" "example good a" $ reverseWords "a good   example"
    ]
