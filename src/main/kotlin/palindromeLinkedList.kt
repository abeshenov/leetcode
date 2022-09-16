// https://leetcode.com/problems/palindrome-linked-list/

// Reusing reverseLinkedList.kt and middleOfLinkedList.kt:
fun isPalindrome(head: ListNode?): Boolean =
    linkedListEquals(head, reverseList(middleNode(head)))

private fun linkedListEquals(head1: ListNode?, head2: ListNode?): Boolean =
    head1 == null || head2 == null ||
            (head1.`val` == head2.`val` && linkedListEquals(head1.next, head2.next))
