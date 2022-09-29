//       date: 2022-09-29
//      title: Find k closest elements
//        url: https://leetcode.com/problems/find-k-closest-elements/
// difficulty: medium
//------------------------------------------------------------------------------

fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
    val left = closestBinSearch(arr, k, x)
    return arr.slice(left until left + k).toList()
}

private tailrec fun closestBinSearch(arr: IntArray, k: Int, x: Int, left: Int = 0, right: Int = arr.size - k): Int =
    if (left >= right) {
        left
    } else {
        val mid: Int = (left + right) / 2
        if (x - arr[mid] > arr[mid + k] - x) {
            closestBinSearch(arr, k, x, mid + 1, right)
        } else {
            closestBinSearch(arr, k, x, left, mid)
        }
    }
