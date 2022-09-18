//      title: Peak Index in a Mountain Array
//        url: https://leetcode.com/problems/peak-index-in-a-mountain-array/
// difficulty: medium
//------------------------------------------------------------------------------

fun peakIndexInMountainArray(arr: IntArray): Int {
    var left = 1
    var right = arr.size - 2

    while (left < right) {
        val midpoint = left + (right - left) / 2

        if (arr[midpoint - 1] < arr[midpoint] && arr[midpoint] > arr[midpoint + 1]) {
            return midpoint
        }

        if (arr[midpoint - 1] < arr[midpoint] && arr[midpoint] < arr[midpoint + 1]) {
            left = midpoint + 1
        }

        if (arr[midpoint - 1] > arr[midpoint] && arr[midpoint] > arr[midpoint + 1]) {
            right = midpoint - 1
        }
    }

    return left
}
