package kwaymerge.ksmallestelement;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import utils.IntArray2DConverter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KthSmallestTest {

    @CsvSource(value = {
        "2,6,8:3,7,10:5,8,11;3;5",
        "1,2,3:4,5,6:7,8,9;4;4",
        "1,4:2,5;4;5",
        "1,3,5,7,9:2,4,6,8,10:11,13,15,17,19:12,14,16,18,20:21,22,23,24,25;11;11",
        "2,4,4:5,6,10:6,7,18;4;5"
    }, delimiter = ';')
    @ParameterizedTest
    void shouldReturnKthSmallestElement(@ConvertWith(IntArray2DConverter.class) int[][] arr, int k, int expected) {
        // given
        KthSmallest kthSmallest = new KthSmallest();

        // when
        int result = kthSmallest.kthSmallestElement(arr, k);

        // then
        assertEquals(expected, result);
    }

    @CsvSource(value = {
//        "2,6,8:3,7,10:5,8,11;3;5",
//        "1,2,3:4,5,6:7,8,9;4;4",
//        "1,4:2,5;4;5",
//        "1,3,5,7,9:2,4,6,8,10:11,13,15,17,19:12,14,16,18,20:21,22,23,24,25;11;11",
        "2,4,4:5,6,10:6,7,18;4;5"
    }, delimiter = ';')
    @ParameterizedTest
    void shouldReturnKthSmallestElement2(@ConvertWith(IntArray2DConverter.class) int[][] arr, int k, int expected) {
        // given
        KthSmallest2 kthSmallest = new KthSmallest2();

        // when
        int result = kthSmallest.kthSmallestElement(arr, k);

        // then
        assertEquals(expected, result);

    }
}
