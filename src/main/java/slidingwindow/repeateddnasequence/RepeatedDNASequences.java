package slidingwindow.repeateddnasequence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class RepeatedDNASequences {

    private final static int BASE = 4;

    private final HashMap<Character, Integer> mapping = new HashMap<>() {
        {
            put('A', 1);
            put('C', 2);
            put('G', 3);
            put('T', 4);
        }
    };

    // Ej: H(ACG)=H(A)+H(C)+H(G) = 1 * 4^2 + 2 * 4^1 + 3 * 4^0 = 1 * 16 + 2 * 4 + 3 * 1 = 27

    public Set<String> getSequences(String s, int k) {
        int hiPlaceValue = (int) Math.pow(BASE, k); // BASE -> four elements A, C, G, T
        int hash = 0;
        Set<Integer> seen = new HashSet<>();
        Set<String> output = new HashSet<>();
        for (int start = 0; start < s.length() - k + 1; ++start) {
            if (start == 0) {
                for (int j = 0; j < k; j++) {
                    hash = hash * BASE + mapping.get(s.charAt(j));
                }
            } else {
                hash = hash * BASE - mapping.get(s.charAt(start - 1)) * hiPlaceValue + mapping.get(s.charAt(start + k - 1));
            }
            if (seen.contains(hash)) output.add(s.substring(start, start + k));
            seen.add(hash);
        }
        return output;
    }
}
