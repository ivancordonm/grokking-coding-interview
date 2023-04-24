package slidingwindow.longestsubstring;

import java.util.HashMap;

public class LongestSubstring {

    public int findLongestSubstring(String str) {
        var window = new HashMap<Character, Integer>();
        var maxLength = 0;
        var start = 0;
        for(int i = 0; i < str.length(); i++) {
            var c = str.charAt(i);
            if(window.containsKey(c) && window.get(c) >= start) {
                if (i - start + 1 > maxLength) maxLength = i - start;
                start = window.get(c) + 1;
            }
            window.put(c,i);
        }
        if(str.length() - start > maxLength) maxLength = str.length() - start;
        return maxLength;
    }
}
