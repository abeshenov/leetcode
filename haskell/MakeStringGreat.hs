--       date: 2022-11-08
--      title: Make The String Great
--        url: https://leetcode.com/problems/make-the-string-great/
-- difficulty: easy
--------------------------------------------------------------------------------
module MakeStringGreat
  ( makeGood
  , tests
  ) where

import           Data.Char  (ord)
import           Test.HUnit

makeGood :: String -> String
makeGood str =
  if length str == length betterString
    then str
    else makeGood betterString
  where
    betterString = makeBetter str

makeBetter :: String -> String
makeBetter [] = []
makeBetter [x] = [x]
makeBetter (x:y:ys) =
  if abs (ord x - ord y) == 32
    then makeBetter ys
    else x : makeBetter (y : ys)

--------------------------------------------------------------------------------
-- Tests
tests :: Test
tests =
  TestList
    [ TestCase $ assertEqual "" "leetcode" $ makeGood "leEeetcode"
    , TestCase $ assertEqual "" "" $ makeGood "abBAcC"
    , TestCase $ assertEqual "" "s" $ makeGood "s"
    , TestCase $
      assertEqual "" "cbbABaaCBcac" $
      makeGood "cbbaccCCbBAaCcaAAAbCcaABBaaCBcac"
    , TestCase $
      assertEqual "" "ABaaBaBBBAABBabbAAba" $
      makeGood "ABaBbaBaBBBAABaAAbBaBabbABbAbBba"
    , TestCase $
      assertEqual "" "cBACaaCAccbCaBcA" $
      makeGood "CbBccBACaCAacaCAccaBbAbCacAaCBcA"
    ]
