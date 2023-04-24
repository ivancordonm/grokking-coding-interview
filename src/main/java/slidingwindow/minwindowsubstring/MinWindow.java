package slidingwindow.minwindowsubstring;

import java.util.HashMap;
import java.util.Objects;

public class MinWindow {
    public String minWindow(String s, String t) {
        var rCount = new HashMap<Character, Integer>();
        var window = new HashMap<Character, Integer>();
        for (var i = 0; i < t.length(); i++) {
            var c = t.charAt(i);
            rCount.put(c, rCount.getOrDefault(c, 0) + 1);
        }
        var required = rCount.size();
        var start = 0;
        var end = 0;
        var current = 0;
        var solStart = 0;
        var solEnd = 0;
        while (end < s.length()) {
            var c = s.charAt(end);
            if(rCount.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(Objects.equals(window.get(c), rCount.get(c)))
                    current++;
            }
            while(current == required) {
                if(solEnd == 0 || end + 1 - start < solEnd - solStart) {
                    solStart = start;
                    solEnd = end + 1;
                }
                var c1 = s.charAt(start);
                if(rCount.containsKey(c1)) {
                    window.put(c1, window.get(c1) - 1);
                    if(window.get(c1) < rCount.get(c1))
                        current--;
                }
                start++;
            }
            end++;
        }
        return s.substring(solStart, solEnd);
    }
}
