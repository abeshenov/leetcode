--       date: 2022-11-06
--      title: Orderly Queue
--        url: https://leetcode.com/problems/orderly-queue/
-- difficulty: hard
--------------------------------------------------------------------------------
module OrderlyQueue
  ( orderlyQueue
  , tests
  ) where

import           Data.List  (sort)
import           Test.HUnit

-- This is a trick question.
--
-- - If k = 1, then a move consists of taking the first letter and appending it
--   to the end. This is the cyclic permutation (1,2,...,n), generating
--   a subgroup of order n. We can go through generated permutations
--   and pick the minimum string.
--
-- - If k > 1, then we are allowed to put the second character to the end,
--   and shift everything cyclically:
--   c_1 c_2 ... c_n -> c_1 c_3 c_4 ... c_n c_2 -> ... -> c_2 c_1 c_3 ... c_n.
--   This way we obtain the transposition (1,2). Together with the cyclic
--   permutation (1,2,...,n), it generates all S_n.
--   To get the answer, we can sort the characters of s.
orderlyQueue :: Int -> String -> String
orderlyQueue k =
  if k == 1
    then minimum . cyclicShifts
    else sort

cyclicShifts :: [a] -> [[a]]
cyclicShifts str = take (length str) $ iterate (\(x:xs) -> xs ++ [x]) str

--------------------------------------------------------------------------------
-- Tests
tests :: Test
tests =
  TestList
    [ TestCase $ assertEqual "" "acb" $ orderlyQueue 1 "cba"
    , TestCase $ assertEqual "" "aaabc" $ orderlyQueue 3 "baaca"
    , TestCase $
      assertEqual "" "bjcgsctncliqlkquvrdmckpwgtripwqf" $
      orderlyQueue 1 "iqlkquvrdmckpwgtripwqfbjcgsctncl"
    , TestCase $
      assertEqual "" "amufhconfmtgmrbywdqevhiuilnoynou" $
      orderlyQueue 1 "evhiuilnoynouamufhconfmtgmrbywdq"
    , TestCase $
      assertEqual "" "bbcdefggghhlmnnooooqrssttuuuwyzz" $
      orderlyQueue 2 "sodhyugztgltqhncorbfbgueoszowunm"
    , TestCase $
      assertEqual "" "aabbcdggghjkkkllmnpqrrrtuvvwwwyy" $
      orderlyQueue 10 "cwdhltvrrwuangvmywkygbrgqpjkkbal"
    ]
