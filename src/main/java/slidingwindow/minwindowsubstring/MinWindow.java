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
            if (rCount.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
            }
            if (rCount.containsKey(c) && Objects.equals(rCount.get(c), window.get(c))) current++;
            if (current == required) {
                if(solEnd - solStart + 1 == t.length()) break; // we have found the smallest window
                while(start < end && current == required){
                    var startChar = s.charAt(start);
                    if(window.containsKey(startChar)) {
                        window.put(startChar, window.get(startChar) - 1);
                        if(window.get(startChar) < rCount.get(startChar)) current--;
                    }
                    start++;
                }
                if(end - (start - 1) < solEnd - solStart || solEnd == 0) {
                    solStart = start - 1;
                    solEnd = end;
                }
            }
            end++;
        }
        return s.substring(solStart, solEnd + 1);
    }
}
