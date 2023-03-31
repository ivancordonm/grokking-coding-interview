package fastandslowpointers.middlenode;

import utils.LinkedListNode;

public class MiddeNode {

    public int getMiddleNode(LinkedListNode<Integer> head) {
        var slow = head;
        var fast = head;

        while (true) {
            if (slow.next != null) slow = slow.next;
            else break;
            if (fast.next.next != null) fast = fast.next.next;
            else break;
            if (fast.next == null) break;
        }
        return slow.data;
    }

}
