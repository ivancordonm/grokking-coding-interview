package kwaymerge.kpairssmallestsum;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairs {

    public List<List<Integer>> kSmallestPairs(int[] list1, int[] list2, int target) {

        if (list1 == null || list2 == null || list1.length == 0 || list2.length == 0 || target == 0) {
            return new ArrayList<>();
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        for (int i = 0; i < list1.length && i < target; i++) {
            minHeap.offer(new int[]{i, 0, list1[i] + list2[0]});
        }

        var result = new ArrayList<List<Integer>>();

        while (!minHeap.isEmpty()) {
            if (target == 0) break;
            var removed = minHeap.poll();
            result.add(List.of(list1[removed[0]], list2[removed[1]]));
            target--;
            var i = removed[0];
            var j = removed[1] + 1;
            if (list2.length > j) {
                minHeap.offer(new int[]{i, j, list1[i] + list2[j]});
            }
        }
        return result;
    }

}
