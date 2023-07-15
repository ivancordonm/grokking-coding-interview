package twoheaps.findmediam;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfAStream {

    //Larger numbers than median
    private final PriorityQueue<Integer> minHeap;
    //Smaller numbers than median
    private final PriorityQueue<Integer> maxHeap;

    public MedianOfAStream() {
        minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        maxHeap = new PriorityQueue<>(Comparator.comparingInt(a -> -a));
    }

    public void insertNum(int num) {
        //maxHeap only can be empty at initial, so first element goes to maxHeap
        if (maxHeap.isEmpty() || maxHeap.peek() >= num) maxHeap.add(num);
        else minHeap.add(num);

        //Check if one heap is greater than the other,then balance.
        if (maxHeap.size() > minHeap.size() + 1) minHeap.add(maxHeap.poll());
        else if (maxHeap.size() < minHeap.size()) maxHeap.add(minHeap.poll());
    }

    public double findMedian() {
        if (maxHeap.isEmpty()) return 0.0;
        if (maxHeap.size() == minHeap.size())
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        else
            return maxHeap.peek();
    }
}
