//      title: Combination Sum
//        url: https://leetcode.com/problems/combination-sum/
// difficulty: medium
//------------------------------------------------------------------------------

fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> =
    CombinationHelper(candidates, target).result

class CombinationHelper(candidates: IntArray, private val target: Int) {
    private val candidates: List<Int> = candidates.sorted()
    val result: MutableList<List<Int>> = mutableListOf()

    init {
        combinations(mutableListOf(), 0, 0)
    }

    private fun combinations(currentCombination: MutableList<Int>, accumulatedSum: Int, startIndex: Int) {
        if (accumulatedSum > target) {
            return
        }

        if (accumulatedSum == target) {
            result.add(currentCombination.toList())
            return
        }

        for (i in startIndex until candidates.size) {
            if (accumulatedSum + candidates[i] > target) {
                return
            }

            currentCombination.add(candidates[i])
            combinations(currentCombination, accumulatedSum + candidates[i], i)
            currentCombination.removeAt(currentCombination.size - 1)  // removeLast() was added in 1.4
        }
    }
}
