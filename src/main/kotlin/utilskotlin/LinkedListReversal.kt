package utilskotlin

class LinkedListReversal<T> {

    fun reversedLinkedListNode(node: LinkedListNode<T>?): LinkedListNode<T>? {

        var current: LinkedListNode<T>? = node
        var prev: LinkedListNode<T>? = null
        var next: LinkedListNode<T>?

        while(current != null) {
            next = current.next
            current.next = prev
            prev = current
            current = next
        }

        return prev
    }

}
