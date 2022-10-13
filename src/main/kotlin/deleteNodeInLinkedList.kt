//       date: 2022-10-13
//      title: Delete Node in a Linked List
//        url: https://leetcode.com/problems/delete-node-in-a-linked-list/
// difficulty: medium
//------------------------------------------------------------------------------

fun deleteNode(node: ListNode) {
    if (node.next != null) {  // always the case for this problem
        node.value = node.next!!.value
        node.next = node.next!!.next
        // (since we don't know the previous node)
    }
}
