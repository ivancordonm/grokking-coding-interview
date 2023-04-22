package slidingwindow.minwindowsubsequence;

public class MinWindow {
    public String getMinimumString(String str1, String str2) {
        var indexStr1 = 0;
        var indexStr2 = 0;
        var minStr = "";
        while (indexStr1 < str1.length()) {
            if (str2.charAt(indexStr2) == str1.charAt(indexStr1)) indexStr2++;
            if (indexStr2 == str2.length()) {
                indexStr2--;
                var start = indexStr1;
                var end = indexStr1 + 1;
                while (indexStr2 >= 0) {
                    if (str2.charAt(indexStr2) == str1.charAt(start)) indexStr2--;
                    start--;
                }
                start++;
                indexStr2 = 0;
                if (minStr.isEmpty() || minStr.length() > end - start) {
                    minStr = str1.substring(start, end);
                }
            }
            indexStr1++;
        }
        return minStr;
    }
}
