package twoheaps.maximizecapital;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximizeCapital {
    public int maximumCapital(int c, int k, int[] capitals, int[] profits) {
        var n = capitals.length;
        var currentCapital = c;
        PriorityQueue<int[]> capitalMinHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (var i = 0; i < n; ++i) {
            capitalMinHeap.offer(new int[]{capitals[i], i});
        }
        PriorityQueue<int[]> profitsMaxHeap = new PriorityQueue<>(Comparator.comparingInt(a -> -a[0]));
        var i = 0;
        while (i < k) {
            while (!capitalMinHeap.isEmpty() && capitalMinHeap.peek()[0] <= currentCapital) {
                int[] j = capitalMinHeap.poll();
                profitsMaxHeap.offer(new int[]{profits[j[1]], j[1]});
            }
            if (profitsMaxHeap.isEmpty()) {
                break;
            }
            int x = profitsMaxHeap.poll()[0];
            currentCapital += x;
            i++;
        }
        return currentCapital;
    }
}
