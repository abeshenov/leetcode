--       date: 2022-09-18
--      title: Trapping Rain Water
--        url: https://leetcode.com/problems/trapping-rain-water/
-- difficulty: hard
--------------------------------------------------------------------------------

trap :: [Integer] -> Integer
trap height =
  sum $
  zipWith3
    (\x y z -> min x y - z)
    (leftMaximums height)
    (rightMaximums height)
    height

leftMaximums :: [Integer] -> [Integer]
leftMaximums = scanl1 max

rightMaximums :: [Integer] -> [Integer]
rightMaximums = reverse . leftMaximums . reverse


{--
import Control.Exception.Base (assert)

assert (6 == trap [0,1,0,2,1,0,1,3,2,1,2,1]) ()
assert (9 == trap [4,2,0,3,2,5]) ()
--}
