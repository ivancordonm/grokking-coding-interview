package topkelements.klargest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import utils.IntArrayConverter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KthLargestElementTest {

    @CsvSource(value = {
        "5,2,9,-3,7;1;9",
        "5,2,9,-3,7;2;7"
    }, delimiter = ';')
    @ParameterizedTest(name = "should return {2} for {0} and {1}")
    void findKthLargest(@ConvertWith(IntArrayConverter.class) int[] arr, int k, int expected) {
        // given
        KthLargestElement kthLargestElement = new KthLargestElement();

        // when
        int actual = kthLargestElement.findKthLargest(arr, k);

        // then
        assertEquals(expected, actual);
    }
}
