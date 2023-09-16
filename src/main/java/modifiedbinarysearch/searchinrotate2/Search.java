package modifiedbinarysearch.searchinrotate2;

public class Search {
    public boolean search(int[] arr, int t) {
        var left = 0;
        var right = arr.length - 1;
        while (left <= right) {
            var mid = left + (right - left) / 2;
            if (arr[mid] == t) {
                return true;
            }
            // I always find first the sorted part because it is easier to check if the target is in the sorted part
            if (arr[mid] <= arr[right]) {
                if (t > arr[mid] && t <= arr[right]) {
                    left = mid + 1;
                } else { // in case, target is not in the sorted part, go to the unsorted part
                    right = mid - 1;
                }
            } else {
                if (t < arr[mid] && t >= arr[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}
