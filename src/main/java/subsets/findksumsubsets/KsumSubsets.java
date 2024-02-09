package subsets.findksumsubsets;

import java.util.ArrayList;
import java.util.List;

public class KsumSubsets {

    private boolean getBit(int i, int bit) {
        int temp = (1 << bit);
        temp = temp & i;
        return temp != 0;
    }

    public List<List<Integer>> getKSumSubsets(List<Integer> setOfIntegers, int targetSum) {
        if (setOfIntegers == null || setOfIntegers.isEmpty()) {
            return new ArrayList<>();
        }
        List<List<Integer>> sets = new ArrayList<>();
        var numSets = Math.pow(2, setOfIntegers.size());
        for (int i = 0; i < numSets; i++) {
            List<Integer> set = new ArrayList<>();
            for (int j = 0; j < setOfIntegers.size(); j++) {
                if (getBit(i, j)) set.add(setOfIntegers.get(j));
            }
            if (!set.isEmpty()) sets.add(set);
        }
        sets.removeIf(set -> set.stream().mapToInt(Integer::intValue).sum() != targetSum);
        return sets;
    }
}
