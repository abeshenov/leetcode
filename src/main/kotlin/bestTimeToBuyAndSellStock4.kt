//       date: 2022-09-10
//      title: Best Time to Buy and Sell Stock IV
//        url: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
// difficulty: hard
//------------------------------------------------------------------------------

fun maxProfit(k: Int, prices: IntArray): Int {
    // If there are zero days, we may return 0:
    if (prices.isEmpty()) {
        return 0
    }

    // A transaction consists of buying and selling, so for k larger than
    // prices.size/2 the result is the same as for process.size/2:
    if (k > prices.size/2) {
        return maxProfit(prices.size/2, prices)
    }

    // maxNoStock[i][j] :=
    //   max profit on i-th step after <= j transactions, with no stock at hand
    val maxNoStock: Array<IntArray> = Array(prices.size) { IntArray(k + 1) }

    // Initial values are maxNoStock[i][0] = 0  for all i
    //                    maxNoStock[0][j] = 0  for all j

    // maxWithStock[i][j] :=
    //   max profit on i-th step after <= j transactions, with stock at hand
    val maxWithStock: Array<IntArray> = Array(prices.size) { IntArray(k + 1) }

    // If on the first day (i = 0) we have stock,
    // then we just bought it and the profit is -prices[0]:
    for (j in 0..k) {
        maxWithStock[0][j] = -prices[0]
    }

    // If there were no completed transactions (j = 0) and we bought stock,
    // then the max. profit (minimum loss) is when the price was the cheapest thus far:
    for (i in 1 until prices.size) {
        maxWithStock[i][0] = Math.max(maxWithStock[i - 1][0], -prices[i])
    }

    // After filling in the border cases i = 0 and j = 0, we compute the tables inductively:
    for (i in 1 until prices.size) {
        for (j in 1..k) {
            // If we have no stock at step i, we either:
            //   1) had no stock at step i - 1,
            //   2) had stock and just sold it, gaining prices[i].
            maxNoStock[i][j] = Math.max(maxNoStock[i - 1][j], maxWithStock[i - 1][j - 1] + prices[i])

            // If we have stock at step i, we either:
            //   1) had stock at step i - 1 and didn't sell it,
            //   2) had no stock and just bought it, losing prices[i]
            maxWithStock[i][j] = Math.max(maxWithStock[i - 1][j], maxNoStock[i - 1][j] - prices[i])
        }
    }

    // We want to end up with no stock at hand:
    return maxNoStock[prices.lastIndex][k]
}
