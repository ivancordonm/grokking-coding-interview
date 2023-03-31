package fastandslowpointers.palindromelinkedlist;

import utils.LinkedListReversal;
import utils.LinkedListNode;

import java.util.Objects;

public class LinkedListPalindrome {
    public boolean isPalindrome(LinkedListNode<Integer> head) {

        var slow = head;
        var fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        var linkedListReversal = new LinkedListReversal<Integer>();
        var revHead = linkedListReversal.reverseLinkedList(slow);

        while(head != null && revHead != null){
            if(!Objects.equals(head.data, revHead.data)) return false;
            head = head.next;
            revHead = revHead.next;
        }
        return true;
    }
}
