package slidingwindow.longestsubstring;

import java.util.HashMap;

public class LongestSubstring {

    public int findLongestSubstring(String str) {
        var window = new HashMap<Character, Integer>();
        var maxLength = 0;
        var start = 0;
        for(int i = 0; i < str.length(); i++) {
            var c = str.charAt(i);
            if(window.getOrDefault(c, -1) >= start) {
                maxLength = Math.max(maxLength, i - start);
                start = window.get(c) + 1;
            }
            window.put(c,i);
        }
        maxLength = Math.max(maxLength, str.length() - start);
        return maxLength;
    }
}
