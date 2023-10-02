package subsets.findksumsubsets;

import java.util.ArrayList;
import java.util.List;

public class KsumSubsets {

    private List<Integer> setOfIntegers;

    private List<List<Integer>> getSubsetsRecursive(int index, List<List<Integer>> sets, int target) {
        if (index == setOfIntegers.size()) {
            return sets;
        }

    }

    public List<List<Integer>> getKSumSubsets(List<Integer> setOfIntegers, int targetSum) {
        this.setOfIntegers = setOfIntegers;
        return getSubsetsRecursive(0, new ArrayList<List<Integer>>(), targetSum);
    }
}
