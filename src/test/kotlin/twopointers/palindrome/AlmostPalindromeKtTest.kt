package twopointers.palindrome

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals

class AlmostPalindromeKtTest {

    @ParameterizedTest(name = "#{index} - Test with String : {0}")
    @CsvSource(
        "dead,TRUE",
        "abca,TRUE",
        "tebbem,FALSE",
        "eeccccbebaeeabebccceea,FALSE",
        "ognfjhgbjhzkqhzadmgqbwqsktzqwjexqvzjsopolnmvnymbbzoofzbbmynvmnloposjzvqxejwqztksqwbqgmdazhqkzhjbghjfno,FALSE",
        "abbdba,TRUE",
        "ajkkjab,TRUE",
        "ajkkjb,FALSE"
    )
    fun isAlmostPalindrome(s: String, result: Boolean) {
        assertEquals(result, isAlmostPalindrome(s))
    }

}
