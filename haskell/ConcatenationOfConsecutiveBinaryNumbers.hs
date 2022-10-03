--       date: 2022-09-23
--      title: Concatenation of Consecutive Binary Numbers
--        url: https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/
-- difficulty: medium
--------------------------------------------------------------------------------
module ConcatenationOfConsecutiveBinaryNumbers
  ( concatenatedBinary
  , concatenatedBinaryTests
  ) where

import           Data.List  (transpose)
import           Test.HUnit

concatenatedBinary :: Int -> Int
concatenatedBinary n =
  foldl (\a i -> ((a * (f !! i)) `mod` modulus + i) `mod` modulus) 1 [2 .. n]
  where
    modulus = 10 ^ 9 + 7
    -- f(n) = 2^(# number of binary digits of n)
    f = 1 : xs
      where
        xs = 2 : map (\x -> (x * 2) `mod` modulus) (concat $ transpose [xs, xs])

--------------------------------------------------------------------------------
-- Tests
concatenatedBinaryTests :: Test
concatenatedBinaryTests =
  TestList
    [ TestCase $ assertEqual "" 1 $ concatenatedBinary 1
    , TestCase $ assertEqual "" 6 $ concatenatedBinary 2
    , TestCase $ assertEqual "" 27 $ concatenatedBinary 3
    , TestCase $ assertEqual "" 220 $ concatenatedBinary 4
    , TestCase $ assertEqual "" 1765 $ concatenatedBinary 5
    , TestCase $ assertEqual "" 14126 $ concatenatedBinary 6
    , TestCase $ assertEqual "" 113015 $ concatenatedBinary 7
    , TestCase $ assertEqual "" 1808248 $ concatenatedBinary 8
    , TestCase $ assertEqual "" 28931977 $ concatenatedBinary 9
    , TestCase $ assertEqual "" 462911642 $ concatenatedBinary 10
    , TestCase $ assertEqual "" 406586234 $ concatenatedBinary 11
    , TestCase $ assertEqual "" 505379714 $ concatenatedBinary 12
    ]
