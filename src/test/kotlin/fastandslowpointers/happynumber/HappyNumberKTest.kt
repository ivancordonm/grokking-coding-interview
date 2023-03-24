package fastandslowpointers.happynumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class HappyNumberKTest {

    @ParameterizedTest(name = "#{index} Test with String {0}")
    @CsvSource("23,true", "2147483646,false", "1,true", "19,true", "8,false", "7,true")
    fun isHappyNumber(number: Int, result: Boolean) {
        assertEquals(result, isHappyNumber(number))
    }

}
