package modifiedbinarysearch.singleelement;

public class SingleElement {
    public int singleNonDuplicate(int[] nums) {
        var first = 0;
        var last = nums.length - 1;
        while (first < last) {
            var mid = first + (last - first) / 2;
            if (mid % 2 == 1) mid--;
            if (nums[mid + 1] != nums[mid]) last = mid;
            else first = mid + 2;
        }
        return nums[first];
    }
}
