package modifiedbinarysearch.randompickwithweight;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomPickWithWeight {

    int[] runningSums;
    int totalSum;
    Random random = new Random();

    public RandomPickWithWeight(int[] weights) {
        runningSums = new int[weights.length];
        runningSums[0] = weights[0];
        for (int i = 1; i < weights.length; i++) {
            runningSums[i] = runningSums[i - 1] + weights[i];
        }
        totalSum = runningSums[runningSums.length - 1];
    }

    public static void main(String[] args) {
        int counter = 900000;
        int[][] weights = {
            {1, 2, 3, 4, 5},
            {1, 12, 23, 34, 45, 56, 67, 78, 89, 90},
            {10, 20, 30, 40, 50},
            {1, 10, 23, 32, 41, 56, 62, 75, 87, 90},
            {12, 20, 35, 42, 55},
            {10, 10, 10, 10, 10},
            {10, 10, 20, 20, 20, 30},
            {1, 2, 3},
            {10, 20, 30, 40},
            {5, 10, 15, 20, 25, 30}
        };
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < weights.length; i++) {
            System.out.println((i + 1) + ".\tList of weights: " + Arrays.toString(
                weights[i]) + ", pick_index() called " + counter + " times" + "\n");
            for (int l = 0; l < weights[i].length; l++) {
                map.put(l, 0);
            }
            RandomPickWithWeight sol = new RandomPickWithWeight(weights[i]);
            for (int j = 0; j < counter; j++) {
                int index = sol.pickIndex();
                map.put(index, map.get(index) + 1);
            }
            System.out.println(new String(new char[100]).replace('\0', '-'));
            System.out.println("\t" + String.format("%-10s%-5s%-10s%-5s%-15s%-5s%-20s%-5s%-15s",
                "Indexes", "|", "Weights", "|", "Occurrences", "|", "Actual Frequency", "|", "Expected Frequency"));
            System.out.println(new String(new char[100]).replace('\0', '-'));
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();
                System.out.println("\t" + String.format("%-10s%-5s%-10s%-5s%-15s%-5s%-20s%-5s%-15s",
                    key, "|", weights[i][key], "|", value, "|",
                    String.format("%.2f", ((double) value / counter) * 100) + "%", "|",
                    String.format("%.2f", ((double) weights[i][key] / Arrays.stream(weights[i]).sum()) * 100) + "%"));
            }
            map.clear();
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    public int pickIndex() {
        var randomElement = random.nextInt(totalSum) + 1;  // 1..totalSum
        var left = 0;
        var right = runningSums.length;
        while (left < right) {
            var mid = left + (right - left) / 2;
            if (randomElement > runningSums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
