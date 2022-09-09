// 2022-09-09
// https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/

fun numberOfWeakCharacters(properties: Array<IntArray>): Int {
    val customSortedCharacters: List<Character> = properties.map { arrayToCharacter(it) }
        .sortedWith(characterComparator)

    var maxDefense = Int.MIN_VALUE
    var result = 0

    for (character in customSortedCharacters) {
        if (character.defense < maxDefense) {
            result++
        } else {
            maxDefense = character.defense
        }
    }

    return result
}

private data class Character(val attack: Int, val defense: Int)

/**
 * Example of our custom sorting:
 * [ (6,1), (6,9), (5,9), (5,9), (4,4), (3,6), (3,10), (2,1), (2,5), (1,10) ]
 */
private val characterComparator = compareBy<Character> { chr -> -chr.attack }
    .then(compareBy { chr -> chr.defense } )

private fun arrayToCharacter(property: IntArray): Character =
    Character(property[0], property[1])
