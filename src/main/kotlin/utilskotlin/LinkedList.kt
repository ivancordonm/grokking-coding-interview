package utilskotlin

class LinkedList<T> {

    var head: LinkedListNode<T>? = null

    private fun insertNodeAtHead(node: LinkedListNode<T>) {
        if (head != null) node.next = head
        head = node
    }

    fun createLinkedList(list: Array<T>) = list.reversedArray().forEach { insertNodeAtHead(LinkedListNode(it)) }

}
