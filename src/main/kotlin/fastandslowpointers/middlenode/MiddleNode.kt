package fastandslowpointers.middlenode

import utilskotlin.LinkedListNode


fun getMiddle(head: LinkedListNode<Int>): Int {

    var slow = head
    var fast = head
    while(true) {
        slow = slow.next ?: break
        fast = fast.next?.next ?: break
        fast.next ?: break
    }

    return slow.data
}
