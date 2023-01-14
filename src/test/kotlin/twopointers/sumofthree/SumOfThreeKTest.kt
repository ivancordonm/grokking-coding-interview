package twopointers.sumofthree

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import utils.intArrayConverter

class SumOfThreeKTest {

    @ParameterizedTest(name = "#{index} - Test with String : {0}")
    @CsvSource(
        value = ["1,-1,0;1;FALSE", "3,7,1,2,8,4,5;10;TRUE", "3,7,1,2,8,4,5;20;TRUE", "3,7,1,2,8,4,5;21;FALSE",
            "-1,2,1,-4,5,-3;-8;TRUE", "-1,2,1,-4,5,-3;0;TRUE", "-1,2,1,-4,5,-3;7;FALSE", "3,7,1,2,8,4,5;20;TRUE"],
        delimiterString = ";"
    )
    fun isSumOfThree(input: String, target: Int, result: Boolean) {
        Assertions.assertEquals(result, isSumOfThree(input.intArrayConverter(), target))
    }

}
