//      title: Add Two Numbers
//        url: https://leetcode.com/problems/add-two-numbers/
// difficulty: medium
//------------------------------------------------------------------------------

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val head = ListNode(0)
    var resultPtr: ListNode = head

    var carry = 0

    var firstListPtr: ListNode? = l1
    var secondListPtr: ListNode? = l2

    while (firstListPtr != null || secondListPtr != null || carry != 0) {
        var x = 0
        if (firstListPtr != null) {
            x = firstListPtr.`val`
            firstListPtr = firstListPtr.next
        }

        var y = 0
        if (secondListPtr != null) {
            y = secondListPtr.`val`
            secondListPtr = secondListPtr.next
        }

        var sum = x + y + carry

        if (sum > 9) {
            carry = sum / 10
            sum %= 10
        } else {
            carry = 0
        }

        resultPtr.next = ListNode(sum)
        resultPtr = resultPtr.next!!
    }

    return head.next
}
