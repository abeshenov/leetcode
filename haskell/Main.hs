module Main where

import           AverageOfLevelsInBinaryTree           (averageOfLevels)
import           BinaryTree
import           Data.List                             (sort)
import           FindKClosestElements                  (findClosestElements)
import           NumbersWithSameConsecutiveDifferences (numsSameConsecDiff)
import           PushDominoes                          (pushDominoes)
import           SkylineProblem                        (Building (..), Point (..), getSkyline)
import           Test.HUnit
import           TrappingRainWater                     (trap)

averageOfLevelsInBinaryTreeTests :: Test
averageOfLevelsInBinaryTreeTests =
  TestList
    [ TestCase $ assertEqual "" [3.0, 14.5, 11.0] $ averageOfLevels testTree1
    , TestCase $ assertEqual "" [3.0, 14.5, 11.0] $ averageOfLevels testTree2
    ]
  where
    testTree1 =
      TreeNode
        3
        (TreeNode 9 EmptyTree EmptyTree)
        (TreeNode
           20
           (TreeNode 15 EmptyTree EmptyTree)
           (TreeNode 7 EmptyTree EmptyTree))
    testTree2 =
      TreeNode
        3
        (TreeNode
           9
           (TreeNode 15 EmptyTree EmptyTree)
           (TreeNode 7 EmptyTree EmptyTree))
        (TreeNode 20 EmptyTree EmptyTree)

findKClosestElementsTests :: Test
findKClosestElementsTests =
  TestList
    [ TestCase $
      assertEqual "" [1, 2, 3, 4] $ findClosestElements [1, 2, 3, 4, 5] 4 3
    , TestCase $
      assertEqual "" [1, 2, 3, 4] $ findClosestElements [1, 2, 3, 4, 5] 4 (-1)
    , TestCase $
      assertEqual "" [3, 6, 8, 8, 9] $
      findClosestElements [0, 1, 2, 2, 2, 3, 6, 8, 8, 9] 5 9
    , TestCase $ assertEqual "" [8, 10] $ findClosestElements [3, 5, 8, 10] 2 15
    , TestCase $
      assertEqual "" [10] $ findClosestElements [1, 1, 1, 10, 10, 10] 1 9
    ]

numbersWithSameConsecutiveDifferencesTests :: Test
numbersWithSameConsecutiveDifferencesTests =
  TestList
    [ TestCase $
      assertEqual "" [181, 292, 707, 818, 929] $ sort $ numsSameConsecDiff 3 7
    , TestCase $
      assertEqual
        ""
        [10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87, 89, 98] $
      sort $ numsSameConsecDiff 2 1
    ]

pushDominoesTests :: Test
pushDominoesTests =
  TestList
    [ TestCase $ assertEqual "" "RR.L" $ pushDominoes "RR.L"
    , TestCase $ assertEqual "" "LL.RR.LLRRLL.." $ pushDominoes ".L.R...LR..L.."
    ]

skylineProblemTests :: Test
skylineProblemTests =
  TestList
    [ TestCase $ assertEqual "" expectedSkyline1 $ getSkyline buildings1
    , TestCase $ assertEqual "" expectedSkyline2 $ getSkyline buildings2
    ]
  where
    buildings1 =
      [ Building 2 9 10
      , Building 3 7 15
      , Building 5 12 12
      , Building 15 20 10
      , Building 19 24 8
      ]
    expectedSkyline1 =
      [ Point 2 10
      , Point 3 15
      , Point 7 12
      , Point 12 0
      , Point 15 10
      , Point 20 8
      , Point 24 0
      ]
    buildings2 = [Building 0 2 3, Building 2 5 3]
    expectedSkyline2 = [Point 0 3, Point 5 0]

trappingRainWaterTests :: Test
trappingRainWaterTests =
  TestList
    [ TestCase $ assertEqual "" 6 $ trap [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
    , TestCase $ assertEqual "" 9 $ trap [4, 2, 0, 3, 2, 5]
    ]

main :: IO Counts
main = do
  runTestTT averageOfLevelsInBinaryTreeTests
  runTestTT findKClosestElementsTests
  runTestTT numbersWithSameConsecutiveDifferencesTests
  runTestTT pushDominoesTests
  runTestTT skylineProblemTests
  runTestTT trappingRainWaterTests
