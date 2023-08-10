package kwaymerge.mergeksorted;

import utils.LinkedList;
import utils.LinkedListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeSortList {

    @SuppressWarnings("unchecked")
    public LinkedListNode<Integer> mergeKLists(List<LinkedList<Integer>> lists) {

        var k = lists.size();
        var minHeap = new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[1]));

        LinkedList<Integer> result = new LinkedList<>();
        LinkedListNode<Integer>[] pointers = new LinkedListNode[k];
        LinkedListNode<Integer> rPointer = new LinkedListNode<>(-1);

        for (int i = 0; i < k; i++) {
            pointers[i] = lists.get(i).head;
            minHeap.offer(new int[]{i, pointers[i].data});
            pointers[i] = pointers[i].next;
        }

        while (!minHeap.isEmpty()) {
            var element = minHeap.poll();
            if (result.head == null) {
                result.insertNodeAtHead(new LinkedListNode<>(element[1]));
                rPointer = result.head;
            } else {
                rPointer.next = new LinkedListNode<>(element[1]);
                rPointer = rPointer.next;
            }
            if (pointers[element[0]] != null) {
                minHeap.add(new int[]{element[0], pointers[element[0]].data});
                pointers[element[0]] = pointers[element[0]].next;
            }
        }
        return result.head;
    }
}
