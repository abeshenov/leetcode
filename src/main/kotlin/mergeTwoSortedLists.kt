//      title: Merge Two Sorted Lists
//        url: https://leetcode.com/problems/merge-two-sorted-lists/
// difficulty: easy
//------------------------------------------------------------------------------

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null) {
        return list2
    }

    if (list2 == null) {
        return list1
    }

    return if (list1.value <= list2.value) {
        val result = ListNode(list1.value)
        result.next = mergeTwoLists(list1.next, list2)
        result
    } else {
        val result = ListNode(list2.value)
        result.next = mergeTwoLists(list1, list2.next)
        result
    }
}
