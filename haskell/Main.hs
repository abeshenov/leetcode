module Main where

import           AddOneRowToTree
import           AverageOfLevelsInBinaryTree
import           ConcatenationOfConsecutiveBinaryNumbers
import           CountGoodNodesInBinaryTree
import           DecodeWays
import           FindKClosestElements
import           MinimumTimeToMakeRopeColorful
import           NumberOfDiceRollsWithTargetSum
import           NumbersWithSameConsecutiveDifferences
import           PathSum
import           PseudoPalindromicPathsInBinaryTree
import           PushDominoes
import           SkylineProblem
import           Test.HUnit
import           ThreeSumClosest
import           TrappingRainWater
import           TwoSum4

main :: IO Counts
main = do
  runTestTT addOneRowTests
  runTestTT averageOfLevelsTests
  runTestTT concatenatedBinaryTests
  runTestTT goodNodesTests
  runTestTT findClosestElementsTests
  runTestTT numRollsToTargetTests
  runTestTT numRollsToTargetTests
  runTestTT numsSameConsecDiffTests
  runTestTT pushDominoesTests
  runTestTT hasPathSumTests
  runTestTT pseudoPalindromicPathsTests
  runTestTT getSkylineTests
  runTestTT trapTests
  runTestTT threeSumClosestTests
  runTestTT numDecodingsTests
  runTestTT findTargetTests
