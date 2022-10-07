//       date: 2022-10-07
//      title: My Calendar III
//        url: https://leetcode.com/problems/my-calendar-iii/
// difficulty: hard
//------------------------------------------------------------------------------

import java.util.TreeMap

class MyCalendarThree() {

    private val diff: MutableMap<Int, Int> = TreeMap()

    fun book(start: Int, end: Int): Int {
        diff[start] = diff.getOrDefault(start, 0) + 1
        diff[end] = diff.getOrDefault(end, 0) - 1
        return diff.values.runningReduce { x, y -> x + y }.maxOf { it }
    }

}
