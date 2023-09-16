package subsets.findsubsets;

import java.util.ArrayList;
import java.util.List;

public class FindSubsets {

    // We make a bit mask between the number of set (0..2^n) and the index of the element
    // i.e. in the set 3 (011) the element with index 1 and 2 are present. (index is counted from 1 to n)
    private int getBit(int num, int bit) {
        int temp = (1 << bit);
        temp = temp & num;
        if (temp == 0) {
            return 0;
        }
        return 1;
    }

    // The time complexity of this algorithm is O(n * 2^n), where n is the number of elements in the input set.
    public List<List<Integer>> findAllSubsets(int[] nums) {
        List<List<Integer>> setsList = new ArrayList<>();
        if (nums.length != 0) {
            int subsetsCount = (int) (Math.pow(2, nums.length));
            for (int i = 0; i < subsetsCount; ++i) {
                List<Integer> subset = new ArrayList<>();
                for (int j = 0; j < nums.length; ++j) {
                    if (getBit(i, j) == 1) {
                        int x = nums[j];
                        subset.add(x);
                    }

                }
                setsList.add(subset);
            }
        } else {
            List<Integer> emptySet = new ArrayList<>();
            setsList.add(emptySet);
        }
        return setsList;
    }
}
