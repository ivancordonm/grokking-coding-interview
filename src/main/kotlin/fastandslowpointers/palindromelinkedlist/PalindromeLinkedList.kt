package fastandslowpointers.palindromelinkedlist

import utilskotlin.LinkedListNode
import utilskotlin.LinkedListReversal

fun isPalindromeLinkedList(node: LinkedListNode<Int>): Boolean {

    var head: LinkedListNode<Int>? = node
    var slow: LinkedListNode<Int>? = head
    var fast: LinkedListNode<Int>? = head

    while (fast?.next != null) {
        slow = slow?.next //This is always not null
        fast = fast.next?.next //This is always not null (first next) because of while checking
    }

    var rhead = LinkedListReversal<Int>().reversedLinkedListNode(slow)
    while (head != null && rhead != null) {
        if (head.data != rhead.data) return false
        head = head.next
        rhead = rhead.next
    }

    return true

}
