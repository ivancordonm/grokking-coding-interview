package kwaymerge.mergesortedarray;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import utils.IntArrayConverter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSortedTest {

    @CsvSource(value = {
        "1,2,3,0,0,0;3;4,5,6;3;1,2,3,4,5,6",
        "1,1,0,0;2;1,1;2;1,1,1,1",
        "2,2,0,0;2;1,1;2;1,1,2,2"
    }, delimiter = ';')
    @ParameterizedTest(name = "should merge two arrays {0} and {2} into {4}")
    void shouldMergeTwoArrays(@ConvertWith(IntArrayConverter.class) int[] arr1, int m,
                              @ConvertWith(IntArrayConverter.class) int[] arr2, int n,
                              @ConvertWith(IntArrayConverter.class) int[] expected) {
        // given
        MergeSorted mergeSorted = new MergeSorted();

        // when
        var merged = mergeSorted.mergeSorted(arr1, m, arr2, n);

        // then
        assertArrayEquals(merged, expected);

    }


}
