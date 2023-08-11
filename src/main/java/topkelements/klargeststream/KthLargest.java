package topkelements.klargeststream;

import java.util.Optional;
import java.util.PriorityQueue;

class KthLargest {

    private final PriorityQueue<Integer> topKHeap = new PriorityQueue<>();
    private final int k;

    // constructor to initialize topKHeap and add values in it
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (var num : nums)
            topKHeap.offer(num);
        var size = topKHeap.size();
        while (size-- > k)
            topKHeap.poll();
    }

    // adds element in the topKHeap
    public int add(int val) {
        topKHeap.offer(val);
        return returnKthLargest();
    }

    // returns kth largest element from topKHeap
    public int returnKthLargest() {
        if (topKHeap.isEmpty())
            return Integer.MIN_VALUE;
        var size = topKHeap.size();
        while (size-- > k)
            topKHeap.poll();
        return Optional.ofNullable(topKHeap.peek()).orElse(Integer.MIN_VALUE);
    }
}
