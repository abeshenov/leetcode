--       date: 2022-10-12
--      title: Largest Perimeter Triangle
--        url: https://leetcode.com/problems/largest-perimeter-triangle/
-- difficulty: easy
--------------------------------------------------------------------------------
module LargestPerimeterTriangle
  ( largestPerimeter
  , tests
  ) where

import           Data.List  (sort)
import           Test.HUnit

largestPerimeter :: (Ord a, Num a) => [a] -> a
largestPerimeter = largestPerimeter' . reverse . sort
  where
    largestPerimeter' (x:y:z:xs) =
      if isTriangle x y z
        then x + y + z
        else largestPerimeter' xs
    largestPerimeter' [_, _] = 0
    largestPerimeter' [_] = 0
    largestPerimeter' [] = 0

isTriangle :: (Ord a, Num a) => a -> a -> a -> Bool
isTriangle a b c = a + b > c

--------------------------------------------------------------------------------
-- Tests
tests :: Test
tests =
  TestList
    [ TestCase $
      assertEqual "" 242 $
      largestPerimeter
        [ 49
        , 57
        , 68
        , 43
        , 95
        , 6
        , 74
        , 57
        , 68
        , 66
        , 65
        , 2
        , 4
        , 45
        , 1
        , 73
        , 18
        , 73
        , 14
        , 34
        ]
    , TestCase $
      assertEqual "" 257 $
      largestPerimeter
        [ 1
        , 75
        , 43
        , 68
        , 90
        , 44
        , 2
        , 33
        , 71
        , 21
        , 47
        , 81
        , 12
        , 2
        , 29
        , 24
        , 33
        , 68
        , 86
        , 43
        ]
    , TestCase $
      assertEqual "" 287 $
      largestPerimeter
        [ 3
        , 30
        , 62
        , 62
        , 16
        , 35
        , 68
        , 38
        , 95
        , 74
        , 45
        , 98
        , 57
        , 32
        , 94
        , 62
        , 67
        , 6
        , 53
        , 85
        ]
    , TestCase $
      assertEqual "" 281 $
      largestPerimeter
        [ 32
        , 34
        , 61
        , 41
        , 53
        , 94
        , 80
        , 50
        , 93
        , 38
        , 69
        , 17
        , 87
        , 94
        , 13
        , 16
        , 16
        , 31
        , 29
        , 35
        ]
    , TestCase $
      assertEqual "" 236 $
      largestPerimeter
        [ 14
        , 19
        , 16
        , 60
        , 38
        , 70
        , 70
        , 43
        , 33
        , 72
        , 2
        , 75
        , 20
        , 16
        , 68
        , 56
        , 89
        , 68
        , 58
        , 4
        ]
    ]
