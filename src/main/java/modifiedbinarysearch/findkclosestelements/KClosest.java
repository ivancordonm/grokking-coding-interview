package modifiedbinarysearch.findkclosestelements;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class KClosest {

    public List<Integer> findClosestElements(int[] nums, int k, int target) {

        // O(n)
        return Arrays.stream(nums)
                     .mapToObj(num -> new int[]{num, Math.abs(num - target)})
                     .sorted(Comparator.comparingInt((int[] a) -> a[1]).thenComparing(a -> a[0]))
                     .limit(k).map(e -> e[0]).sorted().toList();
    }
}
