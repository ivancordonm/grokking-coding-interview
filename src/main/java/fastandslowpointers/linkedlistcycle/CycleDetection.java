package fastandslowpointers.linkedlistcycle;

import utils.LinkedListNode;

public class CycleDetection {

    public boolean detectCycle(LinkedListNode<Integer> head) {
        // Write your code here
        var fast = head;
        var slow = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;

        }
        return false;

    }

}
