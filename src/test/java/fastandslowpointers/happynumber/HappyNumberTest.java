package fastandslowpointers.happynumber;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HappyNumberTest {

    @ParameterizedTest(name = "#{index} Test with String {0}")
    @CsvSource({"23,true","2147483646,false", "1,true", "19,true", "8,false", "7,true"})
    void isHappyNumber(int number, boolean result) {
        var happyNumber = new HappyNumber();
        assertEquals(result, happyNumber.isHappyNumber(number));
    }

}
