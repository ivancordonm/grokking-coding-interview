package modifiedbinarysearch.searchinrotate;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import utils.ListIntConverter;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchTest {

    @CsvSource(value = {
        "6,7,1,2,3,4,5;6;0",
        "6,7,1,2,3,4,5;1;2",
        "6,7,1,2,3,4,5;5;6",
        "6,7,1,2,3,4,5;8;-1",
        " ;1;-1",
        "4,5,6,1,2,3;6;2"
    }, delimiter = ';')
    @ParameterizedTest(name = "search({0} -> {1}) = {2}")
    void search(@ConvertWith(ListIntConverter.class) List<Integer> input, int target, int expected) {
        // given
        var sut = new Search();

        // when
        var actual = sut.binarySearchRotated(input, target);

        // then
        assertEquals(expected, actual);
    }

}
