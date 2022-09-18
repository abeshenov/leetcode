//       date: 2022-09-09
//      title: The Number of Weak Characters in the Game
//        url: https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/
// difficulty: medium
//------------------------------------------------------------------------------

// Shorter / quicker in-place version
fun numberOfWeakCharactersInPlace(properties: Array<IntArray>): Int {
    // Example of our custom sorting:
    // [ (6,1), (6,9), (5,9), (5,9), (4,4), (3,6), (3,10), (2,1), (2,5), (1,10) ]
    val arrayComparator: Comparator<IntArray> =
        compareBy<IntArray> { -it[0] }
            .then(compareBy { it[1] } )

    properties.sortWith(arrayComparator)

    var maxDefense = Int.MIN_VALUE
    var result = 0

    for (prop in properties) {
        if (prop[1] < maxDefense) {
            result++
        } else {
            maxDefense = prop[1]
        }
    }

    return result
}

//------------------------------------------------------------------------------

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

private val characterComparator: Comparator<Character> =
    compareBy<Character> { -it.attack }
        .then(compareBy { it.defense } )

private fun arrayToCharacter(property: IntArray): Character =
    Character(property[0], property[1])
