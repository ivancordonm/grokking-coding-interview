package kwaymerge.kthsmallest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import utils.ListOfListOfIntConverter;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindSmallestNumberTest {
    @CsvSource(value = {
        "2,6,8:3,7,10:5,8,11;5;7",
        "1,1,1:2,2,2;4;2",
        "1,1:2,2;5;2",
        "1,3,5,7:2,4,6,8;5;5",
        " :1,2;3;2",
        " : : : ;5;0",
        "1,2: : : ;5;2",
    }, delimiter = ';')
    @ParameterizedTest(name = "shouldRerunKthSmallestNumber() = {0} [{1}] -> {2}")
    void shouldRerunKthSmallestNumber(@ConvertWith(ListOfListOfIntConverter.class) List<List<Integer>> input, int k,
                                      int expected) {
        // given
        FindKSmallestNumber findKSmallestNumber = new FindKSmallestNumber();

        // when
        int actual = findKSmallestNumber.kSmallestNumber(input, k);

        // then
        assertEquals(expected, actual);
    }

}
