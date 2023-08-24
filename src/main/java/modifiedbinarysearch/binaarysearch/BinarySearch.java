package modifiedbinarysearch.binaarysearch;

public class BinarySearch {
    public int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                end = middle - 1;
            } else if (nums[middle] < target) {
                start = middle + 1;
            }
        }
        return -1;
    }
}

// 1,2,3,4
// start = 0
// end = 3
// middle = (3 - 0) / 2 = 1 => 2

// 1,2,3,4,5
// start = 0
// end = 3
// middle = (4 - 0) / 2 = 2 => 3
