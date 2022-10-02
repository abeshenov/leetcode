//       date: 2022-10-02
//      title: Number of Dice Rolls With Target Sum
//        url: https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
// difficulty: medium
//------------------------------------------------------------------------------

// Naive recursion:
// numRollsToTarget n k target = dp n target
//    where
//        dp 1 s = if 1 <= s && s <= k then 1 else 0
//        dp i s = sum [dp (i-1) (s - c) | c <- [1..k]] `mod` modulo

fun numRollsToTarget(n: Int, k: Int, target: Int): Int {

    if (n * k < target) {
        return 0
    }

    val dp = Array(n + 1) { LongArray(target + 1) { 0 } }

    for (sum in 1..Math.min(k, target)) {
        dp[1][sum] = 1
    }

    for (i in 2..n) {
        for (sum in 1..(target - n + i)) {
            dp[i][sum] = (1..k).map { c -> if ((sum - c) >= 0) dp[i - 1][sum - c] else 0 }.sumMod(1000000007)
        }
    }

    return dp[n][target].toInt()
}

private fun Iterable<Long>.sumMod(n: Int): Long =
    reduce { x, y -> (x + y) % n }
