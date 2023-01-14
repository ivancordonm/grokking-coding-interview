package twopointers.reversestring;

public class ReverseString {

    public String reverse(String sentence) {
        String reverse = new StringBuilder(sentence).reverse()
                                                    .toString()
                                                    .trim();
        var start = 0;
        var end = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (start < reverse.length()) {
            while (start < reverse.length() && reverse.charAt(start) != ' ') {
                start++;
            }
            var index = start;
            while (start > end) {
                stringBuilder.append(reverse.charAt(--start));
            }
            if (index < reverse.length() - 1) {
                stringBuilder.append(reverse.charAt(index));
                while (reverse.charAt(index) == ' ') {
                    index++;
                }
            }
            start = end = index;
        }

        return stringBuilder.toString();

    }

}
