package twopointers.reversestring

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals

class ReverseStringKtTest {

    @ParameterizedTest(name = "#{index} Test with String: {0}")
    @CsvSource(
        "We love Python,Python love We",
        "To be or not to be,be to not or be To",
        "You are amazing,amazing are You",
        "Hello     World,World Hello",
        "Hey,Hey"
    )

    fun reverse(s: String, result: String) {
        assertEquals(result, reverseString(s))
    }

}
