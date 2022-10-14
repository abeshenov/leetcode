//       date: 2022-10-14
//      title: Delete the Middle Node of a Linked List
//        url: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
// difficulty: medium
//------------------------------------------------------------------------------

fun deleteMiddle(head: ListNode?): ListNode? {
    if (head == null) {
        return null
    }
    val m = size(head) / 2
    return concat(take(m, head), drop(m + 1, head))
}

private fun cons(head: Int, tail: ListNode?): ListNode {
    val listNode = ListNode(head)
    listNode.next = tail
    return listNode
}

private fun size(list: ListNode?, acc: Int = 0): Int =
    if (list == null) acc else size(list.next, acc + 1)

private fun concat(list1: ListNode?, list2: ListNode?): ListNode? =
    if (list1 == null) list2 else cons(list1.value, concat(list1.next, list2))

private fun take(n: Int, xs: ListNode?): ListNode? =
    if (n == 0 || xs == null) null else cons(xs.value, take(n - 1, xs.next))

private fun drop(n: Int, xs: ListNode?): ListNode? =
    if (n == 0 || xs == null) xs else drop(n - 1, xs.next)
