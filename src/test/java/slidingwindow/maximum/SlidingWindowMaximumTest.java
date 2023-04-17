package slidingwindow.maximum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import utils.IntArrayConverter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SlidingWindowMaximumTest {

    @CsvSource(value = {"1,2,3,4,5,6,7,8,9,10;3;3,4,5,6,7,8,9,10",
            "3,3,3,3,3,3,3,3,3,3;4;3,3,3,3,3,3,3",
            "10,6,9,-3,23,-1,34,56,67,-1,-4,-8,-2,9,10,34,67;2;10,9,9,23,23,34,56,67,67,-1,-4,-2,9,10,34,67",
            "4,5,6,1,2,3;1;4,5,6,1,2,3",
            "9,5,3,1,6,3;2;9,5,3,6,6",
    }, delimiterString = ";")
    @ParameterizedTest(name = "Test {index}: findMaxSlidingWindow({0}, {1}) = {2}")
    void findMaxSlidingWindow(@ConvertWith(IntArrayConverter.class) int[] input, int k, @ConvertWith(IntArrayConverter.class) int[] expected) {
        var slidingWindowMaximum = new SlidingWindowMaximum();
        assertArrayEquals(expected, slidingWindowMaximum.findMaxSlidingWindow(input, k));
    }
}
