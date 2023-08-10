package kwaymerge.mergeksorted;

import utils.LinkedList;
import utils.LinkedListNode;

import java.util.List;

public class MergeSortList2 {
    private LinkedListNode<Integer> merge2Lists(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        LinkedListNode<Integer> dummy = new LinkedListNode<>(-1);
        LinkedListNode<Integer> prev = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                prev.next = head1;
                head1 = head1.next;
            } else {
                prev.next = head2;
                head2 = head2.next;
            }
            prev = prev.next;
        }

        if (head1 == null)
            prev.next = head2;
        else
            prev.next = head1;

        return dummy.next;
    }

    // Main function
    public LinkedListNode<Integer> mergeKLists(List<LinkedList<Integer>> lists) {
        if (!lists.isEmpty()) {
            int step = 1;
            while (step < lists.size()) {
                for (int i = 0; i < lists.size() - step; i += step * 2) {
                    lists.get(i).head = merge2Lists(lists.get(i).head, lists.get(i + step).head);
                }
                step *= 2;
            }
            return lists.get(0).head;
        } else
            return null;

    }
}
