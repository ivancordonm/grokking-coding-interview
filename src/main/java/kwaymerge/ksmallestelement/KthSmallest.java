package kwaymerge.ksmallestelement;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class KthSmallest {
    public int kthSmallestElement(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || k <= 0) {
            return -1;
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int i = 0;
        int j = 0;
        minHeap.offer(new int[]{matrix[i][j], i, j});
        int[] result = new int[0];
        HashSet<String> visited = new HashSet<>();
        while (!minHeap.isEmpty() && k > 0) {
            result = minHeap.poll();
            k--;
            i = result[1];
            j = result[2];
            if (i + 1 < matrix.length && !visited.contains((i + 1) + "," + j)) {
                minHeap.offer(new int[]{matrix[i + 1][j], i + 1, j});
                visited.add((i + 1) + "," + j);
            }
            if (j + 1 < matrix[0].length && !visited.contains(i + "," + (j + 1))) {
                minHeap.offer(new int[]{matrix[i][j + 1], i, j + 1});
                visited.add(i + "," + (j + 1));
            }
        }
        return result[0];
    }
}
