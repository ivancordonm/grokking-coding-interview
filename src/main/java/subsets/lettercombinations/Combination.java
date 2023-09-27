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

    private List<String> recursiveCombination(int index, StringBuilder current, String digits, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return result;
        }

        var letters = phone.get(digits.charAt(index) - '0');
        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));
            recursiveCombination(index + 1, current, digits, result);
            current.deleteCharAt(current.length() - 1);
        }

        return result;
    }

    public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }

        return recursiveCombination(0, new StringBuilder(), digits, result);
    }
}
