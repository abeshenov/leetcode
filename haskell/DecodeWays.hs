--       date: 2022-10-01
--      title: Decode Ways
--        url: https://leetcode.com/problems/decode-ways/
-- difficulty: medium
--------------------------------------------------------------------------------
module DecodeWays (numDecodings, numDecodingsTests) where

import           Test.HUnit

-- Let dp[i] be the number of ways to decipher the substring 0..i
-- Consider the string tail ... str[i-2] str[i-1] str[i].
-- a) If a single digit str[i] is a valid number, then dp[i] += dp[i-1]
-- b) If str[i-1] str[i] is also a valid number, then dp[i] += dp[i-2]
-- c) Otherwise, dp[i] = 0.
numDecodings :: [Char] -> Int
numDecodings [] = 1
numDecodings [d] =
  if isValidCode [d]
    then 1
    else 0
numDecodings [d1, d2] = singleOption + splitOption
  where
    singleOption =
      if isValidCode [d1, d2]
        then 1
        else 0
    splitOption =
      if isValidCode [d1] && isValidCode [d2]
        then 1
        else 0
numDecodings str = dp (length str - 1)
  where
    dp 0 = numDecodings (take 1 str)
    dp 1 = numDecodings (take 2 str)
    dp i =
      (if isValidCode [str !! i]
         then dp (i - 1)
         else 0) +
      (if isValidCode [str !! (i - 1), str !! i]
         then dp (i - 2)
         else 0)

-- Valid numbers are from "1" to "26".
-- We should reject strings like "06", only "6" is valid
isValidCode :: [Char] -> Bool
isValidCode [] = False
isValidCode [d] = '1' <= d && d <= '9'
isValidCode [d1, d2] = d1 /= '0' && 1 <= val && val <= 26
  where
    val = read [d1, d2] :: Int
isValidCode _ = False

numDecodingsTests :: Test
numDecodingsTests =
  TestList
    [ TestCase $ assertEqual "" 2 $ numDecodings "12"
    , TestCase $ assertEqual "" 3 $ numDecodings "226"
    , TestCase $ assertEqual "" 0 $ numDecodings "06"
    , TestCase $
      assertEqual "" 320 $
      numDecodings "9976421093469582315631211511184959388481337534"
    ]
