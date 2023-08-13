package topkelements.reorganizestrings;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Reorganize {

    public String reorganizeString(String string1) {

        HashMap<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : string1.toCharArray()) {
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
            (a, b) -> charFrequencyMap.get(b) - charFrequencyMap.get(a));

        maxHeap.addAll(charFrequencyMap.keySet());

        Character previousChar = null;

        StringBuilder reorganized = new StringBuilder();
        while (!maxHeap.isEmpty() || previousChar != null) {
            if (previousChar != null && maxHeap.isEmpty()) return "";

            Character currentChar = maxHeap.poll();
            reorganized.append(currentChar);
            charFrequencyMap.put(currentChar, charFrequencyMap.get(currentChar) - 1);

            if (previousChar != null) {
                maxHeap.add(previousChar);
                previousChar = null;
            }

            if (charFrequencyMap.get(currentChar) > 0) {
                previousChar = currentChar;
            }
        }

        return reorganized.toString();
    }
}
