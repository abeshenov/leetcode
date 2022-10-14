--       date: 2022-10-10
--      title: Break a Palindrome
--        url: https://leetcode.com/problems/break-a-palindrome/
-- difficulty: medium
--------------------------------------------------------------------------------
module BreakPalindrome
  ( breakPalindrome
  , tests
  ) where

import           Test.HUnit

breakPalindrome :: String -> String
breakPalindrome palindrome
  | length palindrome == 1 = ""
  | canReplaceFirstNotA palindrome = replaceFirstNotA palindrome
  | otherwise = replaceLastA palindrome

canReplaceFirstNotA :: String -> Bool
canReplaceFirstNotA str = any (/= 'a') $ half str

half :: [a] -> [a]
half xs = take (length xs `div` 2) xs

replaceFirstNotA :: String -> String
replaceFirstNotA (x:xs) =
  if x == 'a'
    then x : replaceFirstNotA xs
    else 'a' : xs

replaceFirstA :: String -> String
replaceFirstA (x:xs) =
  if x == 'a'
    then 'b' : xs
    else x : replaceFirstA xs

replaceLastA :: String -> String
replaceLastA = reverse . replaceFirstA . reverse

--------------------------------------------------------------------------------
-- Tests
tests :: Test
tests =
  TestList
    [ TestCase $ assertEqual "" "" $ breakPalindrome "x"
    , TestCase $ assertEqual "" "aaba" $ breakPalindrome "abba"
    , TestCase $
      assertEqual "" "abbccbccbaabccbccbbc" $
      breakPalindrome "cbbccbccbaabccbccbbc"
    , TestCase $
      assertEqual "" "aaabbccbacabccbbbaa" $
      breakPalindrome "aabbbccbacabccbbbaa"
    , TestCase $ assertEqual "" "abbbb" $ breakPalindrome "bbbbb"
    , TestCase $ assertEqual "" "aaaab" $ breakPalindrome "aaaaa"
    , TestCase $ assertEqual "" "aaabaab" $ breakPalindrome "aaabaaa"
    ]
