package slidingwindow.minsizesubarraysum;

public class MinSubArrayLen {

    public int minSubArrayLen(int target, int[] arr) {
        var minLen = Integer.MAX_VALUE;
        var sum = 0;
        var l = 0;
        for (int r = 0; r < arr.length; r++) {
            sum += arr[r];
            while (sum >= target) {
                if (r - l + 1 < minLen) minLen = r - l + 1;
                sum -= arr[l++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
