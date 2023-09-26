package subsets.lettercombinations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Combination {

    private final Map<Integer, String> phone = Map.of(
        1, "",
        2, "abc",
        3, "def",
        4, "ghi",
        5, "jkl",
        6, "mno",
        7, "pqrs",
        8, "tuv",
        9, "wxyz");

    private List<String> recursiveCombination(List<String> result, String digits) {
        if (digits.isEmpty()) {
            return result;
        }

        int digit = Integer.parseInt(digits.substring(0, 1));
        result = recursiveCombination(result, digits.substring(1));
    }

    public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }


    }
}
