package fastandslowpointers.circulararray

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import utils.intArrayConverter

class CircularArrayLoopKtTest {


    @ParameterizedTest(name = "#{index} test with array {0}")
    @CsvSource(
        value = ["1,2,3,4,5;true", "1,3,-2,-4,1;true", "2,1,-1,-2;false", "3,2,1,1,-4,1;false",
            "1,2,-3,3,4,7,1;true", "-1,-1,-1,-1,-1,-1;true"],
        delimiterString = ";"
    )
    fun circularArrayLoop(input: String, result: Boolean) {
        Assertions.assertEquals(result, circularArrayLoop(input.intArrayConverter()))
    }

}
