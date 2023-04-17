package slidingwindow.maximum;

public class SlidingWindowMaximum {

    public int[] findMaxSlidingWindow(int[] nums, int w) {
        var result = new int[nums.length - w + 1];
        var maxIndex = 0;
        for (var i = 0; i < nums.length; i++) {
            // Remove elements outside the current window
            if (i >= w && maxIndex <= i - w) {
                maxIndex++;
            }
            // Update the index of the maximum element in the current window
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
            // Add the maximum element to the result array
            if (i >= w - 1) {
                result[i - w + 1] = nums[maxIndex];
            }
        }
        return result;
    }
}
