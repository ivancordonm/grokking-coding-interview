package fastandslowpointers.happynumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class HappyNumberKTest {

    @ParameterizedTest(name = "#{index} Test with String {0}")
    @CsvSource("23,TRUE", "2147483646,FALSE", "1,TRUE", "19,TRUE", "8,FALSE", "7,TRUE")
    fun isHappyNumber(number: Int, result: Boolean) {
        assertEquals(result, isHappyNumber(number))
    }

}
