--       date: 2022-09-03
--      title: Numbers With Same Consecutive Differences
--        url: https://leetcode.com/problems/numbers-with-same-consecutive-differences/
-- difficulty: medium

numsSameConsecDiff :: Integer -> Integer -> [Integer]
numsSameConsecDiff n k = concatMap (numsSameConsecDiffHelper n k) [1 .. 9]

numsSameConsecDiffHelper :: Integer -> Integer -> Integer -> [Integer]
numsSameConsecDiffHelper 1 k firstDigit =
  if (0 <= firstDigit && firstDigit <= 9)
    then [firstDigit]
    else []
numsSameConsecDiffHelper numOfDigits k firstDigit =
  if (0 <= firstDigit && firstDigit <= 9)
    then map (addFirstDigit (numOfDigits - 1) firstDigit) smallerNumbers
    else []
  where
    smallerNumbers =
      numsSameConsecDiffHelper (numOfDigits - 1) k (firstDigit + k) ++
      numsSameConsecDiffHelper (numOfDigits - 1) k (firstDigit - k)
    addFirstDigit numOfDigits digit num = num + 10 ^ numOfDigits * digit
