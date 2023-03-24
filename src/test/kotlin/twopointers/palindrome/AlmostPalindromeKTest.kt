package twopointers.palindrome

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals

class AlmostPalindromeKTest {

    @ParameterizedTest(name = "#{index} - Test with String : {0}")
    @CsvSource(
        "dead,true",
        "abca,true",
        "tebbem,false",
        "eeccccbebaeeabebccceea,false",
        "ognfjhgbjhzkqhzadmgqbwqsktzqwjexqvzjsopolnmvnymbbzoofzbbmynvmnloposjzvqxejwqztksqwbqgmdazhqkzhjbghjfno,false",
        "abbdba,true",
        "ajkkjab,true",
        "ajkkjb,false"
    )
    fun isAlmostPalindrome(s: String, result: Boolean) {
        assertEquals(result, isAlmostPalindrome(s))
    }

}
