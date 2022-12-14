module Main where

import           Test.HUnit

import qualified AddOneRowToTree                         (tests)
import qualified AverageOfLevelsInBinaryTree             (tests)
import qualified BreakPalindrome                         (tests)
import qualified CheckIfTwoStringArraysAreEquivalent     (tests)
import qualified ConcatenationOfConsecutiveBinaryNumbers (tests)
import qualified CountAndSay                             (tests)
import qualified CountGoodNodesInBinaryTree              (tests)
import qualified DecodeWays                              (tests)
import qualified DeleteMiddleNodeOfLinkedList            (tests)
import qualified FindKClosestElements                    (tests)
import qualified IncreasingTripletSubsequence            (tests)
import qualified IntegerToRoman                          (tests)
import qualified KthLargestElement                       (tests)
import qualified LargestPerimeterTriangle                (tests)
import qualified MakeStringGreat                         (tests)
import qualified MinimumTimeToMakeRopeColorful           (tests)
import qualified NumberOfDiceRollsWithTargetSum          (tests)
import qualified NumbersWithSameConsecutiveDifferences   (tests)
import qualified OrderlyQueue                            (tests)
import qualified PathSum                                 (tests)
import qualified PseudoPalindromicPathsInBinaryTree      (tests)
import qualified PushDominoes                            (tests)
import qualified RemoveAllAdjacentDuplicatesInString     (tests)
import qualified RemoveDuplicatesFromSortedArray         (tests)
import qualified ReverseVowelsOfString                   (tests)
import qualified ReverseWordsInString                   (tests)
import qualified SetMismatch                             (tests)
import qualified SkylineProblem                          (tests)
import qualified ThreeSumClosest                         (tests)
import qualified TrappingRainWater                       (tests)
import qualified TwoSum4                                 (tests)

main :: IO Counts
main = do
  runTestTT AddOneRowToTree.tests
  runTestTT AverageOfLevelsInBinaryTree.tests
  runTestTT BreakPalindrome.tests
  runTestTT CheckIfTwoStringArraysAreEquivalent.tests
  runTestTT ConcatenationOfConsecutiveBinaryNumbers.tests
  runTestTT CountAndSay.tests
  runTestTT CountGoodNodesInBinaryTree.tests
  runTestTT DecodeWays.tests
  runTestTT DeleteMiddleNodeOfLinkedList.tests
  runTestTT FindKClosestElements.tests
  runTestTT IncreasingTripletSubsequence.tests
  runTestTT IntegerToRoman.tests
  runTestTT KthLargestElement.tests
  runTestTT LargestPerimeterTriangle.tests
  runTestTT MakeStringGreat.tests
  runTestTT MinimumTimeToMakeRopeColorful.tests
  runTestTT NumberOfDiceRollsWithTargetSum.tests
  runTestTT NumbersWithSameConsecutiveDifferences.tests
  runTestTT OrderlyQueue.tests
  runTestTT PathSum.tests
  runTestTT PseudoPalindromicPathsInBinaryTree.tests
  runTestTT PushDominoes.tests
  runTestTT RemoveAllAdjacentDuplicatesInString.tests
  runTestTT RemoveDuplicatesFromSortedArray.tests
  runTestTT ReverseVowelsOfString.tests
  runTestTT ReverseWordsInString.tests
  runTestTT SetMismatch.tests
  runTestTT SkylineProblem.tests
  runTestTT ThreeSumClosest.tests
  runTestTT TrappingRainWater.tests
  runTestTT TwoSum4.tests
