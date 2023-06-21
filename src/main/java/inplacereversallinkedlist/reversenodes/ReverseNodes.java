package inplacereversallinkedlist.reversenodes;

import utils.LinkedListNode;

public class ReverseNodes {
    public LinkedListNode<Integer> reverseEvenLengthGroups(LinkedListNode<Integer> head) {

        if (head == null) return null;

        LinkedListNode<Integer> prev = head;
        LinkedListNode<Integer> current = head.next;
        LinkedListNode<Integer> first = head.next;
        LinkedListNode<Integer> next;

        var group = 2;
        var count = 1;

        while (current != null) {
            if (count == group) {
                if (count % 2 == 0) {
                    next = current.next;
                    prev.next = reverseList(first, group);
                    prev = first;
                    first.next = next;
                    current = next;
                    first = next;
                } else {
                    prev = current;
                    first = current.next;
                    current = current.next;
                }
                count = 1;
                group++;
                continue;
            }
            if (current.next == null && count % 2 == 0 && count < group) {
                prev.next = reverseList(first, count);
            }
            count++;
            current = current.next;
        }

        return head;
    }

    private LinkedListNode<Integer> reverseList(LinkedListNode<Integer> head, int k) {

        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> curr = head;
        LinkedListNode<Integer> next;
        var count = 0;

        while (count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        return prev;
    }
}
