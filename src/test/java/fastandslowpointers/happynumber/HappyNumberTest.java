package fastandslowpointers.happynumber;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HappyNumberTest {

    @ParameterizedTest(name = "#{index} Test with String {0}")
    @CsvSource({"23,TRUE","2147483646,FALSE", "1,TRUE", "19,TRUE", "8,FALSE", "7,TRUE"})
    void isHappyNumber(int number, boolean result) {
        var happyNumber = new HappyNumber();
        assertEquals(result, happyNumber.isHappyNumber(number));
    }

}
