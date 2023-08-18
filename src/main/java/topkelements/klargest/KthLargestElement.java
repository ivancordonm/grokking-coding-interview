package topkelements.klargest;

import java.util.PriorityQueue;

public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(nums[i]);
            if (i >= k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

}
