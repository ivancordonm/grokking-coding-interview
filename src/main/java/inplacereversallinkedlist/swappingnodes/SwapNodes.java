package inplacereversallinkedlist.swappingnodes;

import utils.LinkedListNode;

public class SwapNodes {
    public LinkedListNode<Integer> swapNodes(LinkedListNode<Integer> head, int k) {

        var count = 1;
        var current = head;
        while (count < k && current != null) {
            current = current.next;
            count++;
        }
        // k is greater than length of list
        if (current == null) return head;

        var front = current;
        var end = head;

        while (current.next != null) {
            current = current.next;
            end = end.next;
        }

        var temp = front.data;
        front.data = end.data;
        end.data = temp;

        return head;

    }
}
