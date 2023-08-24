package modifiedbinarysearch.searchinrotate;

import java.util.List;

public class Search {
    public int binarySearchRotated(List<Integer> nums, int target) {
        int head = 0;
        int tail = nums.size() - 1;
        while (head <= tail) {
            int middle = head + (tail - head) / 2;
            if (nums.get(middle) == target) {
                return middle;
            }
            if (nums.get(head) <= nums.get(middle)) {
                if (target >= nums.get(head) && target < nums.get(middle)) {
                    tail = middle - 1;
                } else {
                    head = middle + 1;
                }
            } else {
                if (target > nums.get(middle) && target <= nums.get(tail)) {
                    head = middle + 1;
                } else {
                    tail = middle - 1;
                }
            }
        }
        return -1;
    }
}
