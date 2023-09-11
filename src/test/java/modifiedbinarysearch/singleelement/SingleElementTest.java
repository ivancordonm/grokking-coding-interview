package modifiedbinarysearch.singleelement;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import utils.IntArrayConverter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SingleElementTest {

    @CsvSource(value = {
        "1,1,2,2,3,4,4;3",
        "1,1,2,2,3,3,4,4,5,8,8;5",
        "3,3,7,7,10,11,11;10",
        "1,1,2,3,3,4,4,8,8;2",
        "1,1,2,2,3,4,4,8,8;3"
    }, delimiter = ';')
    @ParameterizedTest(name = "should return {1} when nums = {0}")
    void shouldReturnSingleElement(@ConvertWith(IntArrayConverter.class) int[] nums, int expected) {
        // given
        SingleElement singleElement = new SingleElement();

        // when
        int actual = singleElement.singleNonDuplicate(nums);

        // then
        assertEquals(expected, actual);
    }

}
