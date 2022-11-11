--       date: 2022-11-10
--      title: Remove All Adjacent Duplicates In String
--        url: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
-- difficulty: easy
--------------------------------------------------------------------------------
module RemoveAllAdjacentDuplicatesInString
  ( removeDuplicates
  , tests
  ) where

import           Test.HUnit

removeDuplicates :: Eq a => [a] -> [a]
removeDuplicates xs =
  if length xs == length xs'
    then xs
    else removeDuplicates xs'
  where
    xs' = removeAdjacent xs

removeAdjacent [] = []
removeAdjacent [x] = [x]
removeAdjacent (x:y:ys) =
  if x == y
    then removeAdjacent ys
    else x : removeAdjacent (y : ys)

--------------------------------------------------------------------------------
-- Tests
tests :: Test
tests =
  TestList
    [ TestCase $ assertEqual "" "ca" $ removeDuplicates "abbaca"
    , TestCase $ assertEqual "" "ay" $ removeDuplicates "azxxzy"
    , TestCase $
      assertEqual "" "bababababa" $
      removeDuplicates "babababbaaaabaabbaabbbaaaababaaa"
    , TestCase $
      assertEqual "" "babcbcbacabcacbcac" $
      removeDuplicates "aabcbccbaacabcbcbacabcbbabbcbcac"
    , TestCase $
      assertEqual "" "cadbdadabcdacbdc" $
      removeDuplicates "dbaabdcadbdbbadabcdabbddcaabccdc"
    ]
