package fastandslowpointers.circulararray

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import utils.intArrayConverter

class CircularArrayLoopKtTest {


    @ParameterizedTest(name = "#{index} test with array {0}")
    @CsvSource(
        value = ["1,3,-2,-4,1;TRUE", "2,1,-1,-2;FALSE", "1,3,-2,-4,1;TRUE", "1,3,-2,-4,1;FALSE",
            "1,2,-3,3,4,7,1;TRUE", "3,3,1,-1,2;TRUE"],
        delimiterString = ";"
    )
    fun circularArrayLoop(input: String, result: Boolean) {
        Assertions.assertEquals(result, circularArrayLoop(input.intArrayConverter()))
    }

}
