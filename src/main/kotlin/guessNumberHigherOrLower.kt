// https://leetcode.com/problems/guess-number-higher-or-lower/

abstract class GuessGame {
    abstract fun guessNumber(n: Int): Int
    fun guess(num: Int): Int {
        TODO()
    }
}

class GuessGameImpl:GuessGame() {
    override fun guessNumber(n: Int): Int {
        var left = 1
        var right = n

        while (left <= right) {
            val num = left + (right - left)/2

            when (guess(num)) {
                0 -> return num
                -1 -> right = num - 1
                +1 -> left = num + 1
            }
        }

        return -1
    }
}
