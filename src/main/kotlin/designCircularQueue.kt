//       date: 2022-09-25
//      title: Design Circular Queue
//        url: https://leetcode.com/problems/design-circular-queue/
// difficulty: medium
//------------------------------------------------------------------------------

class MyCircularQueue(k: Int) {

    private val array: IntArray = IntArray(k)
    private var frontPos = 0
    private var rearPos = -1
    private var length = 0

    fun Front(): Int =
        if (isEmpty()) -1 else array[frontPos]

    fun Rear(): Int =
        if (isEmpty()) -1 else array[rearPos]

    fun enQueue(x: Int): Boolean {
        if (isFull()) {
            return false
        }

        rearPos = (rearPos + 1) % array.size
        array[rearPos] = x
        length++

        return true
    }

    fun deQueue(): Boolean {
        if (isEmpty()) {
            return false
        }

        frontPos = (frontPos + 1) % array.size
        length--

        return true
    }

    fun isEmpty(): Boolean =
        length == 0

    fun isFull(): Boolean =
        length == array.size

}
