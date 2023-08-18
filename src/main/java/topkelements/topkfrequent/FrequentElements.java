package topkelements.topkfrequent;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class FrequentElements {
    public List<Integer> topKFrequent(int[] arr, int k) {

        HashMap<Integer, Integer> elementFrequency = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            Comparator.comparingInt(a -> elementFrequency.getOrDefault(a, 0)));

        for (var element : arr) {
            elementFrequency.put(element, elementFrequency.getOrDefault(element, 0) + 1);
        }

        for (var entry : elementFrequency.entrySet()) {
            minHeap.add(entry.getKey());
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return List.copyOf(minHeap);
    }
}
