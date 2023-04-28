package slidingwindow.bestbuystock;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import utils.IntArrayConverter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxProfitTest {

    @CsvSource(value = {
            "1,2,4,2,5,7,2,4,9,0,9;9",
            "10,4,11,1,5;7"
    }, delimiterString = ";")
    @ParameterizedTest(name = "should return {1} for {0}")
    void getMaxProfit(@ConvertWith(IntArrayConverter.class) int[] prices, int expected) {
        assertEquals(expected, new MaxProfit().getMaxProfit(prices));
    }
}
