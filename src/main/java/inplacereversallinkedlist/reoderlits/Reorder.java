package inplacereversallinkedlist.reoderlits;

import utils.LinkedListNode;

public class Reorder {
    public LinkedListNode<Integer> reorderList(LinkedListNode<Integer> head) {
        // find middle
        var middle = middle(head);
        var first2 = middle.next;
        middle.next = null;
        // reverse second half
        first2 = reverse(first2);
        //merge
        return merge(head, first2);
    }

    private LinkedListNode<Integer> middle(LinkedListNode<Integer> head) {
        var slow = head;
        var fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private LinkedListNode<Integer> reverse(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> next, prev = null;
        var curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private LinkedListNode<Integer> merge(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        var current = head1;
        var first = head1.next;
        var last = head2;
        while (first != null && last != null) {
            current.next = last;
            last = last.next;
            current = current.next;
            current.next = first;
            first = first.next;
            current = current.next;
        }
        return head1;
    }
}
