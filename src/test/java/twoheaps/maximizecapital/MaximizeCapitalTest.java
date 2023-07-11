package twoheaps.maximizecapital;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import utils.IntArrayConverter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximizeCapitalTest {
    @CsvSource(value = {
        "0;1;1,1,2;1,2,3;0",
        "1;2;1,2,2,3;2,4,6,8;11",
        "2;3;1,3,4,5,6;1,2,3,4,5;9",
        "1;3;1,2,3,4;1,3,5,7;12",
        "7;2;6,7,8,10;4,8,12,14;29",
        "2;4;2,3,5,6,8,12;1,2,5,6,8,9;18"
    }, delimiter = ';')
    @ParameterizedTest(name = "test{index}")
    void maximumCapital(int c, int k,
                        @ConvertWith(IntArrayConverter.class) int[] capitals,
                        @ConvertWith(IntArrayConverter.class) int[] profits,
                        int expected) {
        int actual = new MaximizeCapital().maximumCapital(c, k, capitals, profits);
        assertEquals(expected, actual);
    }
}
