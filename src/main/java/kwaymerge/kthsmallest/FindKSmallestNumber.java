package kwaymerge.kthsmallest;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKSmallestNumber {
    public int kSmallestNumber(List<List<Integer>> lists, int k) {
        var m = lists.size();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // First populate minHeap with the fist element of the every list and remove it from the list
        for (int i = 0; i < m; i++) {
            if (!lists.get(i).isEmpty()) {
                minHeap.add(new int[]{lists.get(i).get(0), i});
                lists.get(i).remove(0);
            }
        }
        if (minHeap.isEmpty()) return 0;

        //initialize top to an empty array
        int[] top = new int[0];

        while (k > 0) {
            if (minHeap.isEmpty()) break;
            top = minHeap.poll();
            k--;
            if (!lists.get(top[1]).isEmpty()) {
                minHeap.offer(new int[]{lists.get(top[1]).get(0), top[1]});
                lists.get(top[1]).remove(0);
            }
        }

        return top[0];
    }
}
