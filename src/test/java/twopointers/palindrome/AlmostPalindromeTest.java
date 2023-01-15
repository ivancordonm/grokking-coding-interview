package twopointers.palindrome;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AlmostPalindromeTest {

    @ParameterizedTest(name = "#{index} - Test with String : {0}")
    @CsvSource({"dead,TRUE", "abca,TRUE", "tebbem,FALSE", "eeccccbebaeeabebccceea,FALSE",
            "ognfjhgbjhzkqhzadmgqbwqsktzqwjexqvzjsopolnmvnymbbzoofzbbmynvmnloposjzvqxejwqztksqwbqgmdazhqkzhjbghjfno,FALSE",
            "abbdba,TRUE","ajkkjab,TRUE","ajkkjb,FALSE"})
    void isAlmostPalindrome(String s, boolean result) {
        AlmostPalindrome almostPalindrome = new AlmostPalindrome();
        assertEquals(result, almostPalindrome.isPalindrome(s));
    }

}
