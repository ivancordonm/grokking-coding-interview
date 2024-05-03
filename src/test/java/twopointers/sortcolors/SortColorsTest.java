package twopointers.sortcolors;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import utils.IntArrayConverter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortColorsTest {

    @CsvSource(value = {
        "0,1,0;0,0,1",
        "2,0,2,1,1,0;0,0,1,1,2,2",
        "0;0",
        "1;1",
        "2;2",
        "2,2;2,2"
    }, delimiter = ';')

    @ParameterizedTest(name = "{index} => input={0}, expected={1}")
    void sortColors(@ConvertWith(IntArrayConverter.class) int[] input,
                    @ConvertWith(IntArrayConverter.class) int[] expected) {
        var result = new SortColors().sortColors(input);
        assertArrayEquals(expected, result);
    }
}
