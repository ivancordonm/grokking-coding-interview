package utils;

public class LinkedListNode<T> {

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

}
