package fastandslowpointers.duplicatenumber;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import utils.IntArrayConverter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindDuplicateTest {

    @CsvSource(value = {
        "3,4,4,4,2;4",
        "1,1;1",
        "1,3,4,2,2;2",
        "1,2,2;2",
        "1,3,6,2,7,3,5,4;3"
    }, delimiter = ';')

    @ParameterizedTest(name = "{index} => input={0}, expected={1}")
    void findDuplicate(@ConvertWith(IntArrayConverter.class) int[] arr, int expected) {
        assertEquals(expected, new FindDuplicate().findDuplicate(arr));
    }
}
