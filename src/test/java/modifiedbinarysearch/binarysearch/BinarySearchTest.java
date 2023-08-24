package modifiedbinarysearch.binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import utils.IntArrayConverter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {

    @CsvSource(value = {
        "1,6,8,10;1;0",
        "1,6,8,10;6;1",
        "1,6,8,10;10;3",
        "1,6,8,10;4;-1",
        " ;1;-1"
    }, delimiter = ';')
    @ParameterizedTest(name = "search({0}) = {1}")
    void search(@ConvertWith(IntArrayConverter.class) int[] input, int target, int expected) {
        // Given
        BinarySearch test = new BinarySearch();

        // When
        int actual = test.binarySearch(input, target);

        // Then
        assertEquals(expected, actual);
    }

}
