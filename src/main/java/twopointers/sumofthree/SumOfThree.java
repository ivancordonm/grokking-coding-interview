package twopointers.sumofthree;

import java.util.Arrays;

public class SumOfThree {

    public boolean findSumOfThree(int[] nums, int target) {
        Arrays.sort(nums);
        int low, high, triples;
        for (int i = 0; i < nums.length - 2; i++) {
            low = i + 1;
            high = nums.length - 1;
            while (low < high) {
                triples = nums[i] + nums[low] + nums[high];
                if (triples == target) {
                    System.out.println(nums[i] + " + " + nums[low] + " + " + nums[high] + " = " + target);
                    return true;
                } else if (triples < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return false;
    }

}
