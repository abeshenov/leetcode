module Main where

import           AverageOfLevelsInBinaryTree
import           ConcatenationOfConsecutiveBinaryNumbers
import           CountGoodNodesInBinaryTree
import           DecodeWays
import           FindKClosestElements
import           MinimumTimeToMakeRopeColorful
import           NumberOfDiceRollsWithTargetSum
import           NumbersWithSameConsecutiveDifferences
import           PseudoPalindromicPathsInBinaryTree
import           PushDominoes
import           SkylineProblem
import           Test.HUnit
import           TrappingRainWater

main :: IO Counts
main = do
  runTestTT averageOfLevelsTests
  runTestTT concatenatedBinaryTests
  runTestTT goodNodesTests
  runTestTT findClosestElementsTests
  runTestTT numRollsToTargetTests
  runTestTT numRollsToTargetTests
  runTestTT numsSameConsecDiffTests
  runTestTT pushDominoesTests
  runTestTT pseudoPalindromicPathsTests
  runTestTT getSkylineTests
  runTestTT trapTests
  runTestTT numDecodingsTests
