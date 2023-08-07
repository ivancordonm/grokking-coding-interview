package kwaymerge.mergeksorted;

import utils.LinkedList;
import utils.LinkedListNode;
import utils.LinkedListReversal;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeSortList {
    public LinkedListNode<Integer> mergeKLists(List<LinkedList<Integer>> lists) {

        var k = lists.size();
        var minHeap = new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[1]));

        LinkedList<Integer> result = new LinkedList<>();
        LinkedListNode<Integer>[] pointers = new LinkedListNode[k];

        for (int i = 0; i < k; i++) {
            pointers[i] = lists.get(i).head;
            minHeap.offer(new int[]{i, pointers[i].data});
            pointers[i] = pointers[i].next;
        }

        while (!minHeap.isEmpty()) {
            var element = minHeap.poll();
            result.insertNodeAtHead(new LinkedListNode<>(element[1]));
            if (pointers[element[0]] != null) {
                minHeap.add(new int[]{element[0], pointers[element[0]].data});
                pointers[element[0]] = pointers[element[0]].next;
            }
        }

        LinkedListReversal<Integer> reversal = new LinkedListReversal<>();
        return reversal.reverseLinkedList(result.head);
    }
}
