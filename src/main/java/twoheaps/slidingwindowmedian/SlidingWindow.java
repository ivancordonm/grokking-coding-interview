package twoheaps.slidingwindowmedian;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindow {
    public double[] medianSlidingWindow(int[] nums, int k) {

        //Smaller half
        var maxHeap = new PriorityQueue<Integer>(Comparator.comparingInt(a -> -a));
        //Larger half
        var minHeap = new PriorityQueue<Integer>(Comparator.comparingInt(a -> a));
        for (var i = 0; i < k; i++) {
            maxHeap.add(nums[i]);
        }
        for (var i = 0; i < k / 2; i++) {
            minHeap.add(maxHeap.poll());
        }
        var balance = maxHeap.size() == minHeap.size() ? 0 : 1;
        var left = 0;
        var result = new double[nums.length - k + 1];

        // It can be a hashmap as well
        ArrayList<Integer> removed = new ArrayList<>();

        result[left] = getMedian(maxHeap, minHeap, balance);
        for (var i = k; i < nums.length; i++) {
            assert !maxHeap.isEmpty(); // maxHeap is never empty
            if (nums[i] <= maxHeap.peek()) {
                maxHeap.add(nums[i]);
                balance++;
            } else {
                minHeap.add(nums[i]);
                balance--;
            }
            var elementToRemove = nums[left++];
            if (!minHeap.isEmpty() && elementToRemove == minHeap.peek()) {
                minHeap.poll();
                balance++;
            } else if (!maxHeap.isEmpty() && elementToRemove == maxHeap.peek()) {
                maxHeap.poll();
                balance--;
            } else if (removed.contains(minHeap.peek())) {
                minHeap.poll();
                balance++;
                removed.remove(minHeap.peek());
            } else if (removed.contains(maxHeap.peek())) {
                maxHeap.poll();
                balance--;
                removed.remove(maxHeap.peek());
            } else {
                removed.add(elementToRemove);
                if (!maxHeap.isEmpty() && elementToRemove < maxHeap.peek())
                    balance--;
                else
                    balance++;
            }

            if (balance > 1) {
                minHeap.add(maxHeap.poll());
                balance -= 2;
            } else if (balance < 0) {
                maxHeap.add(minHeap.poll());
                balance += 2;
            }

            result[left] = getMedian(maxHeap, minHeap, balance);

        }
        return result;
    }

    private double getMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, int balance) {
        assert !maxHeap.isEmpty(); // maxHeap is never empty
        assert !minHeap.isEmpty(); // minHeap is never empty
        return balance == 0 ? ((double) maxHeap.peek() + minHeap.peek()) / 2.0 : maxHeap.peek();
    }
}
