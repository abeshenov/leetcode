// https://leetcode.com/problems/delete-node-in-a-linked-list/

fun deleteNode(node: ListNode) {
    if (node.next != null) {  // always the case for this problem
        node.`val` = node.next!!.`val`
        node.next = node.next!!.next
        // (since we don't know the previous node)
    }
}
