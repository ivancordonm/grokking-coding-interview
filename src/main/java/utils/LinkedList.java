package utils;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T>{

    public LinkedListNode<T> head;

    public LinkedList() {
        this.head = null;
    }

    public void insertNodeAtHead(LinkedListNode<T> node) {
        if (this.head != null) {
            node.next = this.head;
        }
        this.head = node;
    }

    public void createLinkedList(T[] lst) {
        for (int i = lst.length - 1; i >= 0; i--) {
            LinkedListNode<T> newNode = new LinkedListNode<>(lst[i]);
            insertNodeAtHead(newNode);
        }
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<>(this);
    }

    static class LinkedListIterator<T> implements Iterator<T> {
        private LinkedListNode<T> current;

        public LinkedListIterator(LinkedList<T> list) {
            this.current = list.head;
        }

        @Override
        public boolean hasNext() {
            return this.current != null;
        }

        @Override
        public T next() {
            T data = this.current.data;
            this.current = this.current.next;
            return data;
        }
    }
}
