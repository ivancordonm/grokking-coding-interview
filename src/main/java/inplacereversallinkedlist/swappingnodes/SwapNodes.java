package inplacereversallinkedlist.swappingnodes;

import utils.LinkedListNode;

public class SwapNodes {
    public LinkedListNode<Integer> swapNodes(LinkedListNode<Integer> head, int k) {

        var count = 1;
        LinkedListNode<Integer> curr = head, front = null, end = null;

        while (curr != null) {
            if (end != null) end = end.next;
            if (count == k) {
                front = curr;
                end = head;
            }
            count++;
            curr = curr.next;
        }

        if (front == null || end == null) return head;
        var temp = front.data;
        front.data = end.data;
        end.data = temp;

        return head;
    }
}
