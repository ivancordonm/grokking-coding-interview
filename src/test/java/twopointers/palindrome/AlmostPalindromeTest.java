package twopointers.palindrome;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AlmostPalindromeTest {

    @ParameterizedTest(name = "#{index} - Test with String : {0}")
    @CsvSource({"dead,true", "abca,true", "tebbem,false", "eeccccbebaeeabebccceea,false",
            "ognfjhgbjhzkqhzadmgqbwqsktzqwjexqvzjsopolnmvnymbbzoofzbbmynvmnloposjzvqxejwqztksqwbqgmdazhqkzhjbghjfno,false",
            "abbdba,true","ajkkjab,true","ajkkjb,false"})
    void isAlmostPalindrome(String s, boolean result) {
        AlmostPalindrome almostPalindrome = new AlmostPalindrome();
        assertEquals(result, almostPalindrome.isPalindrome(s));
    }

}
