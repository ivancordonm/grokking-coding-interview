package inplacereversallinkedlist.reverselinkedlist2;

import utils.LinkedListNode;

public class ReverseLinkedList2 {
    public LinkedListNode<Integer> reverseBetween(LinkedListNode<Integer> head, int left, int right) {

        if (right == left) {
            return head;
        }

        LinkedListNode<Integer> current = head, prev = null;
        int count = 1;

        // Find leftNode, prev and current
        while (count < left) {
            prev = current;
            current = current.next;
            count++;
        }

        // Reverse from left to right
        LinkedListNode<Integer> leftNode = prev, rightNode = current;
        while (count <= right) {
            var next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        // Connect left and right
        if (leftNode == null) {
            head = prev;
        } else {
            leftNode.next = prev;
        }
        rightNode.next = current;

        return head;
    }

}
