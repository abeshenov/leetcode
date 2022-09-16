// https://leetcode.com/problems/reverse-linked-list/

// Clever solution:
fun reverseList(head: ListNode?): ListNode? {
    var currNode: ListNode? = head
    var prevNode: ListNode? = null
    var nextNode: ListNode? = null

    while (currNode != null) {
        nextNode = currNode.next  // remember next node
        currNode.next = prevNode  // relink curr -> prev

        // advance:
        prevNode = currNode
        currNode = nextNode
    }
    return prevNode
}

// Example of how this works on [1,2,3,4]:
//   Step 0: 1 -> 2 -> 3 -> 4 -> None
//   Step 1: 1 -> None, 2 -> 3 -> 4 -> None
//   Step 2: 2 -> 1 -> None, 3 -> 4 -> None
//   Step 3: 3 -> 2 -> 1 -> None, 4 -> None
//   Step 4: 4 -> 3 -> 2 -> 1 -> None


fun reverseListRecursive(head: ListNode?): ListNode? =
    when (head) {
        null -> null
        else -> append(reverseListRecursive(head.next), head.`val`)
    }

// In-place append
private fun append(list: ListNode?, elem: Int): ListNode {
    return if (list == null) {
        ListNode(elem)
    } else {
        var listPtr = list
        while (listPtr!!.next != null) {
            listPtr = listPtr.next
        }
        listPtr.next = ListNode(elem)
        list
    }
}
