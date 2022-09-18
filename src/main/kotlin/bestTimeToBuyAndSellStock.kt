//      title: Best Time to Buy and Sell Stock
//        url: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
// difficulty: easy
//------------------------------------------------------------------------------

fun maxProfit(prices: IntArray): Int {
    var lowestPrice = prices[0]
    var maxProfit = 0

    var i = 1

    while (i < prices.size) {
        val price = prices[i]
        lowestPrice = Math.min(lowestPrice, price)
        maxProfit = Math.max(maxProfit, price - lowestPrice)
        i++
    }

    return maxProfit
}
