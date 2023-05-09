package inplacereversallinkedlist.reverselinkedlist;

import utils.LinkedListNode;

public class ReverseLinkedList {
    public LinkedListNode<Integer> reverse(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> prev = null, current = head, next;
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }
}
