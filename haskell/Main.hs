module Main where

import           AverageOfLevelsInBinaryTree
import           BinaryTree
import           DecodeWays
import           FindKClosestElements
import           NumbersWithSameConsecutiveDifferences
import           PushDominoes
import           SkylineProblem
import           Test.HUnit
import           TrappingRainWater

main :: IO Counts
main = do
  runTestTT averageOfLevelsTests
  runTestTT findClosestElementsTests
  runTestTT numsSameConsecDiffTests
  runTestTT pushDominoesTests
  runTestTT getSkylineTests
  runTestTT trapTests
  runTestTT numDecodingsTests
