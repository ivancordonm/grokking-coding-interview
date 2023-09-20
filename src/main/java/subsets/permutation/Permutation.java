package subsets.permutation;

import java.util.ArrayList;

public class Permutation {


    public ArrayList<String> permuteWord(String word) {

        var permutations = new ArrayList<String>();

        return permuteWordRecursive(word, 0, permutations);

    }

    private String swap(String word, int currentIndex, int i) {
        var wordArray = word.toCharArray();

        var temp = wordArray[currentIndex];
        wordArray[currentIndex] = wordArray[i];
        wordArray[i]            = temp;

        return String.valueOf(wordArray);
    }

    private ArrayList<String> permuteWordRecursive(String word, int currentIndex, ArrayList<String> permutations) {

        if (currentIndex == word.length() - 1) {
            permutations.add(word);
            return permutations;
        } else {
            for (int i = currentIndex; i < word.length(); i++) {
                word         = swap(word, currentIndex, i);
                permutations = permuteWordRecursive(word, currentIndex + 1, permutations);
            }
        }

        return permutations;

    }
}
