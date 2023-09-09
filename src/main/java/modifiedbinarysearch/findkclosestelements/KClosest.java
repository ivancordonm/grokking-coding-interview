package modifiedbinarysearch.findkclosestelements;

import utils.BinarySearch;

import java.util.ArrayList;
import java.util.List;


public class KClosest {

    // I have used this method to convert array to list instead of using Arrays.stream(nums).boxed().toList()
    // because it is O(n) and the below method is O(k)
    private List<Integer> getListOfArray(int[] arr, int start, int end) {
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    public List<Integer> findClosestElements(int[] nums, int k, int target) {

//        O(n)
//        return Arrays.stream(nums)
//                     .mapToObj(num -> new int[]{num, Math.abs(num - target)})
//                     .sorted(Comparator.comparingInt((int[] a) -> a[1]).thenComparing(a -> a[0]))
//                     .limit(k).map(e -> e[0]).sorted().toList();


        ArrayList<Integer> result = new ArrayList<>();

        if (nums == null || nums.length == 0) return null;
        if (k == 0) return result;
        if (k == nums.length) return getListOfArray(nums, 0, nums.length - 1);
        if (target <= nums[0]) return getListOfArray(nums, 0, k - 1);
        if (target >= nums[nums.length - 1]) return getListOfArray(nums, nums.length - k, nums.length - 1);

        var left = 0;
        var right = nums.length - 1;
        var closestIndex = BinarySearch.binarySearch(nums, target);
        left = closestIndex;
        right = closestIndex;

        while (right - left + 1 < k) {
            if (left <= 0) right++;
            else if (right >= nums.length - 1) left--;
            else if (Math.abs(nums[left - 1] - target) <= Math.abs(nums[right + 1] - target)) left--;
            else right++;
        }

        return getListOfArray(nums, left, right);
    }
}
