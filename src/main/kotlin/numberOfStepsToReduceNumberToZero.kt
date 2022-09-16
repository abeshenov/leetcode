// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/

fun numberOfSteps(num: Int): Int =
    numberOfStepsHelper(num)

private tailrec fun numberOfStepsHelper(num: Int, acc: Int = 0): Int =
    when {
        num == 0 -> acc
        num % 2 == 1 -> numberOfStepsHelper(num - 1, acc + 1)
        else -> numberOfStepsHelper(num ushr 1, acc + 1)
    }
