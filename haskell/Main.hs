module Main where

import           AddOneRowToTree
import           AverageOfLevelsInBinaryTree
import           BreakPalindrome
import           ConcatenationOfConsecutiveBinaryNumbers
import           CountGoodNodesInBinaryTree
import           DecodeWays
import           DeleteMiddleNodeOfLinkedList
import           FindKClosestElements
import           IncreasingTripletSubsequence
import           LargestPerimeterTriangle
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
  runTestTT breakPalindromeTests
  runTestTT concatenatedBinaryTests
  runTestTT goodNodesTests
  runTestTT deleteMiddleTests
  runTestTT findClosestElementsTests
  runTestTT increasingTripletTests
  runTestTT largestPerimeterTests
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
