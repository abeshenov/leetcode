// https://leetcode.com/problems/first-bad-version/

abstract class VersionControl {
    abstract fun firstBadVersion(n: Int): Int

    fun isBadVersion(num: Int): Boolean {
        TODO()
    }
}

class VersionControlImpl: VersionControl() {
    override fun firstBadVersion(n: Int) : Int {
        var left = 1
        var right = n

        while (left < right) {
            val num = left + (right - left)/2

            if (isBadVersion(num)) {
                right = num
            } else {
                left = num + 1
            }
        }

        return left
    }
}
