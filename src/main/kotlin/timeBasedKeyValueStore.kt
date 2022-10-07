//       date: 2022-10-06
//      title: Time Based Key-Value Store
//        url: https://leetcode.com/problems/time-based-key-value-store/
// difficulty: medium
//------------------------------------------------------------------------------

import java.util.TreeMap

class TimeMap {
    private val keyMap: MutableMap<String, TreeMap<Int, String>> = mutableMapOf()

    fun set(key: String, value: String, timestamp: Int) {
        keyMap.computeIfAbsent(key) { TreeMap() }
        keyMap[key]!![timestamp] = value
    }

    fun get(key: String, timestamp: Int): String {
        val timestampMap = keyMap[key] ?: return ""
        val floorKey = timestampMap.floorKey(timestamp) ?: return ""
        return timestampMap[floorKey]!!
    }
}
