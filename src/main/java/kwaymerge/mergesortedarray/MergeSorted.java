package kwaymerge.mergesortedarray;

public class MergeSorted {

    public int[] mergeSorted(int[] nums1, int m, int[] nums2, int n) {
        var p1 = m - 1;
        var p2 = n - 1;
        var p = m + n - 1;

        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        if (p2 >= 0) {
            System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        }
        return nums1;
    }
}
