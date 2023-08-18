package topkelements.topkfrequentword;

import java.util.*;

public class FrequentWords {

    public List<String> topKFrequent(String[] arr, int k) {

        HashMap<String, Integer> stringFrequency = new HashMap<>();
        PriorityQueue<String> minHeap = new PriorityQueue<>(
            Comparator.comparingInt((String a) -> stringFrequency.getOrDefault(a, 0))
                      .thenComparing(Comparator.reverseOrder()));

        for (var word : arr) stringFrequency.put(word, stringFrequency.getOrDefault(word, 0) + 1);

        for (var element : stringFrequency.entrySet()) {
            minHeap.offer(element.getKey());
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        var result = new ArrayList<>(minHeap);
        Collections.reverse(result);
        return result;
    }
}
