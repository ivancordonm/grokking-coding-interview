package slidingwindow.repeateddnasequence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RepeatedDNASequences {
    public List<String> getSequences(String s, int k) {
        int i = 0;
        HashMap<String, Integer> counter = new HashMap<>();
        while (i < s.length() - k) {
            String sub = s.substring(i, i + k);
            counter.put(sub, counter.getOrDefault(sub, 0) + 1);
            i++;
        }
        return counter.entrySet().stream().filter(it -> it.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
    }
}
