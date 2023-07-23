package twoheaps.slidingwindowmedian;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import utils.DoubleArrayConverter;
import utils.IntArrayConverter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SlidingWindowTest {

    @CsvSource(value = {
        "1,3,-1,-3,5,3,6,7;3;1.0,-1.0,-1.0,3.0,5.0,6.0",
        "-7,2,5,-2,3,-1;2;-2.5,3.5,1.5,0.5,1",
        "1,3,-1,-3,5,3,6,7;5;1.0,3.0,3.0,5.0",
        "1,2;1;1.0,2.0",
    }, delimiter = ';')
    @ParameterizedTest(name = "should return median of {0} with window size {1} as {2}")
    void should_return_median_window(@ConvertWith(IntArrayConverter.class) int[] input, int k,
                                     @ConvertWith(DoubleArrayConverter.class) double[] expected) {
        // given
        SlidingWindow slidingWindow = new SlidingWindow();

        // when
        var actual = slidingWindow.medianSlidingWindow(input, k);

        // then
        assertArrayEquals(expected, actual);

    }

}
