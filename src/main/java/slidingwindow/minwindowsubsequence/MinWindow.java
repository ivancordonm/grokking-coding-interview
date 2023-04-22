package slidingwindow.minwindowsubsequence;

public class MinWindow {
    public String getMinimumString(String s, String t) {
        var indexS = 0;
        var indexT = 0;
        var minStr = "";
        while (indexS < s.length()) {
            while (indexT < t.length() && indexS < s.length()) {
                if(t.charAt(indexT) == s.charAt(indexS)) indexT++;
                indexS++;
            }
            // I'm now at the end of str2. You may or may not have a match
            if(indexT == t.length()) {
                indexT --;
                var start = indexS - 1;
                while(indexT >= 0) {
                    if(t.charAt(indexT) == s.charAt(start)) indexT--;
                    start--;
                }
                start++;
                indexT++;
                if(minStr.isEmpty() || minStr.length() > indexS - start) {
                    minStr = s.substring(start, indexS);
                }
            }
        }
        return minStr;
    }
}
