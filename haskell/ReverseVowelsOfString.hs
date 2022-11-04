--       date: 2022-11-04
--      title: Reverse Vowels of a String
--        url: https://leetcode.com/problems/reverse-vowels-of-a-string/
-- difficulty: easy
--------------------------------------------------------------------------------
module ReverseVowelsOfString
  ( reverseVowels
  , tests
  ) where

import           Test.HUnit

reverseVowels :: String -> String
reverseVowels str = replaceVowels vowels' str
  where
    vowels = filter isVowel str
    vowels' = reverse vowels

isVowel :: Char -> Bool
isVowel chr = chr `elem` "AEIOUaeiou"

replaceVowels :: String -> String -> String
replaceVowels [] ys = ys
replaceVowels _ [] = []
replaceVowels (x:xs) (y:ys) =
  if isVowel y
    then x : replaceVowels xs ys
    else y : replaceVowels (x : xs) ys

--------------------------------------------------------------------------------
-- Tests
tests :: Test
tests =
  TestList
    [ TestCase $ assertEqual "" "holle" $ reverseVowels "hello"
    , TestCase $ assertEqual "" "leotcede" $ reverseVowels "leetcode"
    , TestCase $
      assertEqual "" "zAUdrXMZFvBCYsUSTSonKtXiJdFoyzQM" $
      reverseVowels "zoidrXMZFvBCYsoSTSUnKtXUJdFAyzQM"
    , TestCase $
      assertEqual "" "HXxLFDKztPhYQhxHAxhKiTnWFdLJuamH" $
      reverseVowels "HXxLFDKztPhYQhxHaxhKuTnWFdLJiAmH"
    , TestCase $
      assertEqual "" "nBGWAfIkqNkvavDlrICzVUWqNjuSHKQz" $
      reverseVowels "nBGWufUkqNkvIvDlraCzVIWqNjASHKQz"
    ]
