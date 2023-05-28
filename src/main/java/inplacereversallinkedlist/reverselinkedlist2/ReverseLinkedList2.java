package inplacereversallinkedlist.reverselinkedlist2;

import utils.LinkedListNode;

public class ReverseLinkedList2 {
    public LinkedListNode<Integer> reverseBetween(LinkedListNode<Integer> head, int left, int right) {

        LinkedListNode<Integer> current = head, rightNode, leftNode = head, prev = null, next;
        var count = 1;

        // if left is greater than 1, we need to find leftNode, prev and current
        if(left > 1) {
            while (count < left - 1) {
                current = current.next;
                count++;
            }
            leftNode = current;
            prev = current;
            rightNode = current.next;
            current = current.next;
            count++;
        } else rightNode = current;

        //reverse from left to right
        while (count <= right) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        //connect left
        if(left == 1) head = prev;
        else leftNode.next = prev;

        //connect right
        if(current != null) rightNode.next = current;

        return head;
    }

}
