//       date: 2022-10-03
//      title: Minimum Time to Make Rope Colorful
//        url: https://leetcode.com/problems/minimum-time-to-make-rope-colorful/
// difficulty: medium
//------------------------------------------------------------------------------

fun minCost(colors: String, neededTime: IntArray): Int =
    splitInGroups(colors.zip(neededTime))
        .map(::minCostForGroup).sum()

private fun String.zip(arr: IntArray): List<Pair<Char, Int>> =
    (0 .. Math.min(lastIndex, arr.lastIndex)).map { i -> Pair(get(i), arr[i]) }

private fun splitInGroups(balloonsWithCost: List<Pair<Char, Int>>): List<List<Pair<Char, Int>>> {
    val result: MutableList<MutableList<Pair<Char, Int>>> = mutableListOf()

    for (balloonWithCost in balloonsWithCost) {
        val (color, _) = balloonWithCost

        if (result.isNotEmpty()) {
            val (lastColor, _) = result.last().last()
            if (color == lastColor) {
                result.last().add(balloonWithCost)
            } else {
                result.add(mutableListOf(balloonWithCost))
            }
        } else {
            result.add(mutableListOf(balloonWithCost))
        }
    }

    return result
}

private fun minCostForGroup(group: List<Pair<Char, Int>>): Int {
    val totalCost = group.map(Pair<Char, Int>::second).sum()
    val maxCost = group.map(Pair<Char, Int>::second).reduce(Math::max)
    return totalCost - maxCost
}
