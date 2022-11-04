--       date: 2022-10-20
--      title: Integer to Roman
--        url: https://leetcode.com/problems/integer-to-roman/
-- difficulty: medium
--------------------------------------------------------------------------------
module IntegerToRoman
  ( intToRoman
  , tests
  ) where

import           Control.Exception (assert)
import           Test.HUnit        (Test (..), assertEqual)

romanDigits :: [(Int, String)]
romanDigits =
  [ (1000, "M")
  , (900, "CM")
  , (500, "D")
  , (400, "CD")
  , (100, "C")
  , (90, "XC")
  , (50, "L")
  , (40, "XL")
  , (10, "X")
  , (9, "IX")
  , (5, "V")
  , (4, "IV")
  , (1, "I")
  ]

intToRoman :: Int -> String
intToRoman n = assert (1 <= n && n < 5000) $ intToRoman' romanDigits n
  where
    intToRoman' [] _ = ""
    intToRoman' _ 0 = ""
    intToRoman' ((value, digit):ds) num =
      concat (replicate (num `div` value) digit) ++
      intToRoman' ds (num `mod` value)

--------------------------------------------------------------------------------
-- Tests
tests :: Test
tests =
  TestList $
  map
    (TestCase . (\(num, roman) -> assertEqual "" roman $ intToRoman num))
    fullTest

fullTest =
  [ (1, "I")
  , (2, "II")
  , (3, "III")
  , (4, "IV")
  , (5, "V")
  , (6, "VI")
  , (7, "VII")
  , (8, "VIII")
  , (9, "IX")
  , (10, "X")
  , (11, "XI")
  , (12, "XII")
  , (13, "XIII")
  , (14, "XIV")
  , (15, "XV")
  , (16, "XVI")
  , (17, "XVII")
  , (18, "XVIII")
  , (19, "XIX")
  , (20, "XX")
  , (100, "C")
  , (1000, "M")
  , (4990, "MMMMCMXC")
  , (4991, "MMMMCMXCI")
  , (4992, "MMMMCMXCII")
  , (4993, "MMMMCMXCIII")
  , (4994, "MMMMCMXCIV")
  , (4995, "MMMMCMXCV")
  , (4996, "MMMMCMXCVI")
  , (4997, "MMMMCMXCVII")
  , (4998, "MMMMCMXCVIII")
  , (4999, "MMMMCMXCIX")
  ]
