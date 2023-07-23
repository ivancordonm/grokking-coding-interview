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
        ArrayList<Integer> removed = new ArrayList<>();

        result[left] = getMedian(maxHeap, minHeap, balance);

        for (var i = k; i < nums.length; i++) {
            System.out.println("------------------------------------");
            System.out.println("Before adding:");
            System.out.println("MaxHeap: " + maxHeap);
            System.out.println("MinHeap: " + minHeap);
            System.out.println("Balance: " + balance);
            System.out.println("Element to add: " + nums[i]);
            assert !maxHeap.isEmpty(); // maxHeap is never empty
            if (nums[i] <= maxHeap.peek()) {
                System.out.println("Adding to maxHeap");
                maxHeap.add(nums[i]);
                balance++;
            } else {
                System.out.println("Adding to minHeap");
                minHeap.add(nums[i]);
                balance--;
            }
            System.out.println("------------------");
            System.out.println("After adding:");
            System.out.println("MaxHeap: " + maxHeap);
            System.out.println("MinHeap: " + minHeap);
            System.out.println("Balance: " + balance);
            var elementToRemove = nums[left++];
            System.out.println("Element to remove: " + elementToRemove);
            if (!minHeap.isEmpty() && elementToRemove == minHeap.peek()) {
                System.out.println("Removing from minHeap");
                minHeap.poll();
                balance++;
            } else if (!maxHeap.isEmpty() && elementToRemove == maxHeap.peek()) {
                System.out.println("Removing from maxHeap");
                maxHeap.poll();
                balance--;
            } else if (removed.contains(minHeap.peek())) {
                System.out.println("Removing from minHeap (already removed)");
                minHeap.poll();
                balance++;
                removed.remove(minHeap.peek());
            } else if (removed.contains(maxHeap.peek())) {
                System.out.println("Removing from maxHeap (already removed)");
                maxHeap.poll();
                balance--;
                removed.remove(maxHeap.peek());
            } else {
                removed.add(elementToRemove);
                System.out.println("Adding to removed: " + elementToRemove);
                if (!maxHeap.isEmpty() && elementToRemove < maxHeap.peek())
                    balance--;
                else
                    balance++;
            }

            System.out.println("------------------");
            System.out.println("After removing:");
            System.out.println("MaxHeap: " + maxHeap);
            System.out.println("MinHeap: " + minHeap);
            System.out.println("Balance: " + balance);

            if (balance > 1) {
                minHeap.add(maxHeap.poll());
                balance -= 2;
            } else if (balance < 0) {
                maxHeap.add(minHeap.poll());
                balance += 2;
            }
            System.out.println("------------------");
            System.out.println("After balancing:");
            System.out.println("MaxHeap: " + maxHeap);
            System.out.println("MinHeap: " + minHeap);
            System.out.println("Balance: " + balance);

            result[left] = getMedian(maxHeap, minHeap, balance);
            System.out.println("Result: " + result[left]);

        }
        return result;
    }

    private double getMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, int balance) {
        return balance == 0 ? (maxHeap.peek() + minHeap.peek()) / 2.0 : maxHeap.peek();
    }
}
