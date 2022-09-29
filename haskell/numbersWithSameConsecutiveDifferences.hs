--       date: 2022-09-03
--      title: Numbers With Same Consecutive Differences
--        url: https://leetcode.com/problems/numbers-with-same-consecutive-differences/
-- difficulty: medium
--------------------------------------------------------------------------------

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
    addFirstDigit numOfDigits digit num = num + 10^numOfDigits*digit


{--
import Data.List (sort)
import Control.Exception.Base (assert)

assert ([181,292,707,818,929] == (sort $ numsSameConsecDiff 3 7)) ()
assert ([10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98] == (sort $ numsSameConsecDiff 2 1)) ()
--}
