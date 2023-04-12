package slidingwindow.maximum;

import java.util.ArrayDeque;

public class SlidingWindowMaximum {

    public int[] findMaxSlidingWindow(int[] nums, int w) {
        var result = new int[nums.length - w + 1];
        var currentWindow = new ArrayDeque<Integer>();

        for (var i = 0; i <= nums.length - w; i++) {
            for (var j = i; j < w; j++) {
                if(!currentWindow.isEmpty() && currentWindow.getFirst() < j) currentWindow.removeFirst();
                if(currentWindow.isEmpty()) currentWindow.add(j);
                else {
                    if(currentWindow.getLast() < nums[j]) {
                        currentWindow.removeLast();
                    }
                    currentWindow.addLast(nums[j]);
                }
            }
            result[i] = currentWindow.getFirst();
        }
        return result;
    }
}
