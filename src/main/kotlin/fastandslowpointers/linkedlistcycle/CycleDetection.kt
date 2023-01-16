package fastandslowpointers.linkedlistcycle

import utilskotlin.LinkedListNode

fun detectCycle(head: LinkedListNode<Int>): Boolean {

    var slow = head
    var fast = head

    while (true) {
        slow = slow.next!!
        fast = fast.next?.next?:break
        if (slow == fast) return true
    }
    return false
}
