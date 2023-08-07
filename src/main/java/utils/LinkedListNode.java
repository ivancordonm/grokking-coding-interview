package utils;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class LinkedListNode<T> implements Iterable<T> {

    public T data;
    public LinkedListNode<T> next;

    // Constructor will be used to make a LinkedListNode type object
    public LinkedListNode(T data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return (next != null) ? data + " -> " + next : data.toString();
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new LinkedListNodeIterator<>(this);
    }

    public static class LinkedListNodeIterator<T> implements Iterator<T> {

        private LinkedListNode<T> node;

        public LinkedListNodeIterator(LinkedListNode<T> node) {
            this.node = node;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public T next() {
            T data = node.data;
            node = node.next;
            return data;
        }
    }
}
