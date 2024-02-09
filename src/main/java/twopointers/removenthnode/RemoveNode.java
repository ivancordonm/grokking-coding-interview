package twopointers.removenthnode;

import utils.LinkedListNode;

public class RemoveNode {

    public LinkedListNode<Integer> removeNthLastNode(LinkedListNode<Integer> head, int n) {

        LinkedListNode<Integer> left = head;
        LinkedListNode<Integer> right = head;

        for (int i = 0; i < n; i++) {
            right = right.next;
        }

        // if right is null, it means we need to remove the head
        if (right == null) {
            return head.next;
        }

        while (right.next != null) {
            right = right.next;
            left = left.next;
        }

        left.next = left.next.next;

        return head;

    }
}
