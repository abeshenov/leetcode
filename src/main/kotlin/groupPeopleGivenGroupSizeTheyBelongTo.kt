//      title: Group the People Given the Group Size They Belong To
//        url: https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
// difficulty: medium
//------------------------------------------------------------------------------

fun groupThePeople(groupSizes: IntArray): List<List<Int>> =
    peopleByGroupSize(groupSizes)
        .flatMap { (groupSize, people) -> splitInGroups(groupSize, people) }

private fun peopleByGroupSize(groupSizes: IntArray): Map<Int, List<Int>> {
    val peopleByGroupSize: MutableMap<Int, MutableList<Int>> = mutableMapOf()

    for ((personId, groupSize) in groupSizes.withIndex()) {
        if (peopleByGroupSize[groupSize] == null) {
            peopleByGroupSize[groupSize] = mutableListOf()
        }

        peopleByGroupSize[groupSize]!!.add(personId)
    }

    return peopleByGroupSize
}

private fun splitInGroups(groupSize: Int, people: List<Int>): List<List<Int>> {
    val result: MutableList<MutableList<Int>> = mutableListOf()
    result.add(mutableListOf())

    for (personId in people) {
        if (result[result.size - 1].size >= groupSize) {
            result.add(mutableListOf())
        }

        result[result.size - 1].add(personId)
    }

    return result
}
