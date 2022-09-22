//      title: Remove Duplicates from Sorted List
//        url:  https://leetcode.com/problems/remove-duplicates-from-sorted-list/
// difficulty: easy
//------------------------------------------------------------------------------

fun deleteDuplicates(head: ListNode?): ListNode? {
    var ptr: ListNode? = head

    while (ptr != null) {
        while (ptr.next != null && ptr.`val` == ptr.next!!.`val`) {
            ptr.next = ptr.next!!.next
        }
        ptr = ptr.next
    }

    return head
}
