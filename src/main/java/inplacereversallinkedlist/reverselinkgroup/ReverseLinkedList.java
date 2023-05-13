package inplacereversallinkedlist.reverselinkgroup;

import utils.LinkedListNode;

public class ReverseLinkedList {
    public LinkedListNode<Integer> reverse(LinkedListNode<Integer> head, int k) {
        // 2,3,4,5,6 (2) -> 3,2,5,4,6
        LinkedListNode<Integer> currentGroupEnd = head, prev = null, next = null;
        while (currentGroupEnd != null) {
            //check if there is a group
            for (int i = 1; i < k; i++) {
                if (currentGroupEnd == null) break;
                currentGroupEnd = currentGroupEnd.next;
            }
            if (currentGroupEnd != null) { // there is a group, then reverse and link
                var reversedEnd = next == null ? head : next;
                next = currentGroupEnd.next;
                var reversedStart = reverseList(reversedEnd, next);
                if (prev == null) {
                    head = reversedStart;
                } else {
                    prev.next = reversedStart;                }
                reversedEnd.next = next;
                prev = reversedEnd;
                currentGroupEnd = next;
            }
        }
        return head;
    }

    private LinkedListNode<Integer> reverseList(LinkedListNode<Integer> head, LinkedListNode<Integer> last) {
        LinkedListNode<Integer> prev = null, current = head, next;
        while(current != last) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
