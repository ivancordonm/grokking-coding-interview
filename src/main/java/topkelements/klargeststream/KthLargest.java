package topkelements.klargeststream;

import java.util.Arrays;
import java.util.Optional;
import java.util.PriorityQueue;

class KthLargest {

    private final PriorityQueue<Integer> topKHeap = new PriorityQueue<>();
    private final int k;

    // constructor to initialize topKHeap and add values in it
    public KthLargest(int k, int[] nums) {
        this.k = k;
        Arrays.stream(nums).forEach(topKHeap::offer);
        while (topKHeap.size() > k)
            topKHeap.poll();
    }

    // adds element in the topKHeap
    public int add(int val) {
        topKHeap.offer(val);
        if (topKHeap.size() > k)
            topKHeap.poll();
        return returnKthLargest();
    }

    // returns kth largest element from topKHeap
    public int returnKthLargest() {
        return Optional.ofNullable(topKHeap.peek()).orElse(Integer.MIN_VALUE);
    }
}
