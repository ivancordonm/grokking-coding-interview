package utils;

import java.util.PriorityQueue;

public class PrintUtils {
    public static void printHeap(PriorityQueue<int[]> heap) {
        PriorityQueue<int[]> clone = new PriorityQueue<>(heap);
        System.out.print("[");
        while (!clone.isEmpty()) {
            var element = clone.poll();
            System.out.print("[" + element[0] + ", " + element[1] + ", " + element[2] + "]");
            if (!clone.isEmpty()) System.out.print(", ");
        }
        System.out.println("]");
    }
}
