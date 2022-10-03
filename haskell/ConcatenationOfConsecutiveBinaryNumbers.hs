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
  foldl (\a i -> (a `modProd` (f !! i)) `modSum` i) 1 [2 .. n]
  where
    modulus = 10 ^ 9 + 7
    modSum x y = (x + y) `mod` modulus
    modProd x y = (x * y) `mod` modulus
    -- f(n) = 2^(# number of binary digits of n)
    f = 1 : xs
      where
        xs = 2 : map (modProd 2) (concat $ transpose [xs, xs])

--------------------------------------------------------------------------------
-- Tests
concatenatedBinaryTests :: Test
concatenatedBinaryTests =
  TestList $
  zipWith
    (\arg val -> TestCase $ assertEqual "" val $ concatenatedBinary arg)
    [1 ..]
    [ 1
    , 6
    , 27
    , 220
    , 1765
    , 14126
    , 113015
    , 1808248
    , 28931977
    , 462911642
    , 406586234
    , 505379714
    ]
