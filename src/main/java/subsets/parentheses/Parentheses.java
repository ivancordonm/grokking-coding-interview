package subsets.parentheses;

import java.util.ArrayList;

public class Parentheses {

    private ArrayList<String> generateRecursive(int num, int open, int close, String str, ArrayList<String> result) {
        if (open == num && close == num) {
            result.add(str);
            return result;
        }

        if (open < num) {
            result = generateRecursive(num, open + 1, close, str + "(", result);
        }

        if (close < open) {
            result = generateRecursive(num, open, close + 1, str + ")", result);
        }

        return result;
    }

    public ArrayList<String> generateValidParentheses(int num) {
        if (num == 0) return new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        return generateRecursive(num, 0, 0, "", result);
    }
}
