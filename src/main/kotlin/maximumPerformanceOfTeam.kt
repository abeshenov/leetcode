//       date: 2022-09-11
//      title: Maximum Performance of a Team
//        url: https://leetcode.com/problems/maximum-performance-of-a-team/
// difficulty: hard
//------------------------------------------------------------------------------

import java.util.PriorityQueue

// k is the number of people to pick,
// n = speeds.size = efficiencies.size is not used in code
fun maxPerformance(n: Int, speeds: IntArray, efficiencies: IntArray, k: Int): Int {
    val mod = 1_000_000_007  // this number is prime :-)

    val speedQueue: PriorityQueue<Int> = PriorityQueue(k)

    var maxPerformance: Long = 0
    var sumOfSpeeds: Long = 0

    // We go through pairs (efficiency, speed) sorted by decreasing efficiency,
    // because (team performance) = (sum of speeds) * (min. efficiency)
    for ((efficiency, speed) in efficiencies.zip(speeds).sortedBy { it.first }.reversed()) {
        speedQueue.add(speed)
        sumOfSpeeds += speed
        // Remove speed from the queue head if we already got k members:
        if (speedQueue.size > k) {
            sumOfSpeeds -= speedQueue.poll()
        }

        maxPerformance = Math.max(maxPerformance, sumOfSpeeds * efficiency)
    }

    return (maxPerformance % mod).toInt()
}

// Note about constraints:
//   k <= 10^5, speed[i] <= 10^5, efficiency[i] <= 10^8
// gives max possible performance of 10^18 = 10^5 * 10^5 * 10^8,
// which is *just a bit less* than Long.MAX_VALUE = 2^63 - 1:
//   log_10 (2^63) = 63 * log_10 (2) ~= 18.96.
// This means that we can do intermediate calculations inside Long.
