package modifiedbinarysearch.searchinrotate2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import utils.IntArrayConverter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchTest {

    @CsvSource(value = {
        "22,67,-14,16,19;19;true",
        "-11,-10,1,6,-71,-33;10;false",
        "1,2,4,5,6,-2,0;3;false",
        "1,2,4,5,6,-2,0;6;true",
    }, delimiter = ';')
    @ParameterizedTest(name = "should return {2} when search {1} in {0}")
    void testSearch(@ConvertWith(IntArrayConverter.class) int[] input, int t, boolean expected) {
        // given
        Search search = new Search();

        // when
        var actual = search.search(input, t);

        // then
        assertEquals(expected, actual);
    }

}
