//       date: 2022-09-12
//      title: Bag of Tokens
//        url: https://leetcode.com/problems/bag-of-tokens/
// difficulty: medium
//------------------------------------------------------------------------------

import java.util.LinkedList

fun bagOfTokensScore(tokens: IntArray, initialPower: Int): Int {
    val game = OptimalGame(tokens, initialPower)

    var maxScore = 0

    while (game.canPlay()) {
        game.play()
        maxScore = Math.max(maxScore, game.score)
    }

    return maxScore
}

// Instead of a LinkedList, we could operate on a sorted array with two pointers
private class OptimalGame(tokens: IntArray, initialPower: Int) {

    var score = 0
    var power = initialPower

    val tokenList: LinkedList<Int> = LinkedList(tokens.sorted())

    private fun hasTokens(): Boolean =
        tokenList.isNotEmpty()

    private fun hasNoTokens(): Boolean =
        tokenList.isEmpty()

    fun canPlay(): Boolean =
        hasTokens() && (canPlaySmallestTokenFaceUp() || canPlayLargestTokenFaceDown())

    fun play() {
        if (hasNoTokens()) {
            return
        }

        if (canPlaySmallestTokenFaceUp()) {
            playSmallestTokenFaceUp()
            return
        }

        if (canPlayLargestTokenFaceDown()) {
            playLargestTokenFaceDown()
        }
    }

    private fun canPlaySmallestTokenFaceUp(): Boolean =
        power >= tokenList.first

    private fun canPlayLargestTokenFaceDown(): Boolean =
        score >= 1

    private fun playSmallestTokenFaceUp() {
        val token = tokenList.removeFirst()
        power -= token
        score++
    }

    private fun playLargestTokenFaceDown() {
        val token = tokenList.removeLast()
        power += token
        score--
    }

}
