package utils

import org.junit.jupiter.api.Test
import utilskotlin.LinkedList
import utilskotlin.LinkedListReversal

class LinkedLinkReversalKTest {

    @Test
    fun test() {
        val list = arrayOf(2, 4, 6, 8, 10)
        val linkedList = LinkedList<Int>()
        linkedList.createLinkedList(list)
        val rev = LinkedListReversal<Int>()
        val revHead = rev.reversedLinkedListNode(linkedList.head)
        println(revHead)
    }
}
