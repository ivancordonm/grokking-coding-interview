package slidingwindow.longestsubstring;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestSubstringTest {

    @CsvSource(value = {"abcabcbb,3", "bbbbb,1", "pwwkew,3","abcdbea,5"})
    @ParameterizedTest(name = "Longest substring of {0} is {1}")
    void findLongestSubstring(String input, int expected) {
        LongestSubstring longestSubstring = new LongestSubstring();
        assertEquals(expected, longestSubstring.findLongestSubstring(input));
    }
}
