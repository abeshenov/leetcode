--       date: 2022-09-03
--      title: Numbers With Same Consecutive Differences
--        url: https://leetcode.com/problems/numbers-with-same-consecutive-differences/
-- difficulty: medium
--------------------------------------------------------------------------------
module NumbersWithSameConsecutiveDifferences where

numsSameConsecDiff :: Integer -> Integer -> [Integer]
numsSameConsecDiff n k = concatMap (numsSameConsecDiff' n k) [1 .. 9]

numsSameConsecDiff' :: Integer -> Integer -> Integer -> [Integer]
numsSameConsecDiff' 1 k firstDigit =
  [firstDigit | 0 <= firstDigit && firstDigit <= 9]
numsSameConsecDiff' numOfDigits k firstDigit =
  if 0 <= firstDigit && firstDigit <= 9
    then map (addFirstDigit (numOfDigits - 1) firstDigit) smallerNumbers
    else []
  where
    smallerNumbers =
      numsSameConsecDiff' (numOfDigits - 1) k (firstDigit + k) ++
      numsSameConsecDiff' (numOfDigits - 1) k (firstDigit - k)
    addFirstDigit numOfDigits digit num = num + 10 ^ numOfDigits * digit
