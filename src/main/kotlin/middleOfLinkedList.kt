// https://leetcode.com/problems/middle-of-the-linked-list/

fun middleNode(head: ListNode?): ListNode? {
    var iter: ListNode? = head
    var iterTwiceFast: ListNode? = head

    while (iterTwiceFast != null) {
        if (iterTwiceFast.next == null) {
            return iter
        }

        iter = iter!!.next
        iterTwiceFast = iterTwiceFast.next!!.next
    }

    return iter
}
