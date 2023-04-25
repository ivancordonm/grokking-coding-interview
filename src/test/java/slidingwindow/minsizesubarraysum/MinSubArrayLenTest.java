package slidingwindow.minsizesubarraysum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import utils.IntArrayConverter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinSubArrayLenTest {

    @CsvSource(value = {
//            "2,2,1,3,4,5;9;2",
//            "1,1,1,1,1,1,1,1;11;0",
//            "1,4,4;4;1",
            "2,3,6,1,7;7;1"
    }, delimiter = ';')
    @ParameterizedTest(name = "should return {2} for {0} and {1}")
    void minSubArrayLen(@ConvertWith(IntArrayConverter.class) int[] nums, int target, int expected) {
        assertEquals(expected, new MinSubArrayLen().minSubArrayLen(target, nums));
    }
}
