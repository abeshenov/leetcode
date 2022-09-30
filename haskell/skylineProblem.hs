--       date: 2022-09-30
--      title: The Skyline Problem
--        url: https://leetcode.com/problems/the-skyline-problem/
-- difficulty: hard
import           Data.Array (Array, array, bounds, ixmap, listArray, (!))

data Point =
  Point Int Int
  deriving (Show, Eq)

data Building =
  Building Int Int Int
  deriving (Show)

getSkyline :: [Building] -> [Point]
getSkyline buildings = divideAndConquer buildingArray lowerBound upperBound
  where
    (lowerBound, upperBound) = (0, length buildings - 1)
    buildingArray = listArray (lowerBound, upperBound) buildings

-- Divide-and-conquer strategy which recursively splits buildings in half,
-- constructs skyline for each part and merges them.
-- Works with arrays for performance reasons.
divideAndConquer :: Array Int Building -> Int -> Int -> [Point]
divideAndConquer buildings start end
  | start > end = []
  | start == end = [Point xLeft height, Point xRight 0]
  | otherwise = pruneSkyline $ mergeSkylines left right
  where
    Building xLeft xRight height = buildings ! start
    mid = (start + end) `div` 2
    left = divideAndConquer buildings start mid
    right = divideAndConquer buildings (mid + 1) end

-- Removes consecutive points from a list with the same y-coordinate.
-- It is easier to first construct a skyline with redundant points,
-- and then apply pruneSkyline.
pruneSkyline :: [Point] -> [Point]
pruneSkyline [] = []
pruneSkyline (pt:pts) = pt : pruneSkyline' pts y
  where
    Point _ y = pt
    pruneSkyline' [] _ = []
    pruneSkyline' (Point x y:pts) previousY =
      if y == previousY
        then pruneSkyline' pts previousY
        else Point x y : pruneSkyline' pts y

-- Merges two skylines constructed for different buildings.
mergeSkylines :: [Point] -> [Point] -> [Point]
mergeSkylines firstList secondList = mergeSkylines' firstList 0 secondList 0

mergeSkylines' :: [Point] -> Int -> [Point] -> Int -> [Point]
mergeSkylines' [] _ [] _ = []
mergeSkylines' [] firstH secondList _ =
  map (\(Point x y) -> Point x $ max firstH y) secondList
mergeSkylines' firstList _ [] secondH =
  map (\(Point x y) -> Point x $ max secondH y) firstList
mergeSkylines' firstList firstH secondList secondH =
  Point (min firstX secondX) (max firstH' secondH') :
  mergeSkylines' firstList' firstH' secondList' secondH'
  where
    Point firstX firstY:firstTail = firstList
    Point secondX secondY:secondTail = secondList
    (firstList', firstH', secondList', secondH')
      | firstX > secondX = (firstList, firstH, secondTail, secondY)
      | firstX < secondX = (firstTail, firstY, secondList, secondH)
      | firstX == secondX = (firstTail, firstY, secondTail, secondY)

{-
import Control.Exception.Base (assert)

buildings1 = [Building 2 9 10, Building 3 7 15, Building 5 12 12, Building 15 20 10, Building 19 24 8]
expectedSkyline1 = [Point 2 10, Point 3 15, Point 7 12, Point 12 0, Point 15 10, Point 20 8, Point 24 0]
assert (expectedSkyline1 == getSkyline buildings1) ()

buildings2 = [Building 0 2 3, Building 2 5 3]
expectedSkyline2 = [Point 0 3, Point 5 0]
assert (expectedSkyline2 == getSkyline buildings2) ()
-}
