package inplacereversallinkedlist.reversenodes;

import utils.LinkedListNode;

public class ReverseNodes {
    public LinkedListNode<Integer> reverseEvenLengthGroups(LinkedListNode<Integer> head) {

        LinkedListNode<Integer> prev = head;
        LinkedListNode<Integer> next = null;
        LinkedListNode<Integer> current = head.next;
        LinkedListNode<Integer> first = head.next;

        var group = 2;
        var count = 1;

        while (current != null) {
            count++;
            current = current.next;
            if (count == group) {
                if (count % 2 == 0) {
                    next = current.next;
                    prev.next = reverseList(first, group);
                    prev = first;
                    first.next = next;
                    current = next;
                    first = next;
                }
                count = 1;
                group++;
            }
        }

        // last step if the count of the rest less than group but they are even.

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
