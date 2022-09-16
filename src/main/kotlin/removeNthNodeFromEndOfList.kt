// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    var iter: ListNode? = head
    var iterAdvanced: ListNode? = head

    for (i in 1 .. n) {
        iterAdvanced = iterAdvanced?.next
    }

    if (iterAdvanced == null) {
        return iter?.next
    }

    while (iterAdvanced != null) {
        iterAdvanced = iterAdvanced.next

        if (iterAdvanced == null) {
            iter!!.next = iter.next?.next
        } else {
            iter = iter!!.next
        }
    }

    return head
}
