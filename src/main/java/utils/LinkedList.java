package utils;

public class LinkedList<T> {

    public LinkedListNode<T> head;

    // constructor will be used to make a LinkedList type object
    public LinkedList() {
        this.head = null;
    }

    // insertNodeAtHead method will insert a LinkedListNode at head
    // of a linked list.
    public void insertNodeAtHead(LinkedListNode<T> node) {
        if (this.head != null) {
            node.next = this.head;
        }
        this.head = node;
    }

    // createLinkedList method will create the linked list using the
    // given integer array with the help of InsertAthead method.
    public void createLinkedList(T[] lst) {
        for (int i = lst.length - 1; i >= 0; i--) {
            LinkedListNode<T> newNode = new LinkedListNode<>(lst[i]);
            insertNodeAtHead(newNode);
        }
    }

}
