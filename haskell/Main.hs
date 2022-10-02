module Main where

import           AverageOfLevelsInBinaryTree
import           DecodeWays
import           FindKClosestElements
import           NumberOfDiceRollsWithTargetSum
import           NumbersWithSameConsecutiveDifferences
import           PushDominoes
import           SkylineProblem
import           Test.HUnit
import           TrappingRainWater

main :: IO Counts
main = do
  runTestTT averageOfLevelsTests
  runTestTT findClosestElementsTests
  runTestTT numRollsToTargetTests
  runTestTT numsSameConsecDiffTests
  runTestTT pushDominoesTests
  runTestTT getSkylineTests
  runTestTT trapTests
  runTestTT numDecodingsTests
