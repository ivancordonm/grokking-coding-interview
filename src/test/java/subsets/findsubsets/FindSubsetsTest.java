package subsets.findsubsets;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import utils.IntArrayConverter;
import utils.ListOfListOfIntConverter;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class FindSubsetsTest {

    @CsvSource(value = {
        "1,2; :1:2:1,2",
        "1; :1",
        "2,5,7; :2:5:2,5:7:2,7:5,7:2,5,7"
    }, delimiter = ';')
    @ParameterizedTest(name = "Find subsets of {0} should be {1}")
    void shouldFindSubsets(@ConvertWith(IntArrayConverter.class) int[] input,
                           @ConvertWith(ListOfListOfIntConverter.class) List<List<Integer>> expected) {

        // given
        FindSubsets findSubsets = new FindSubsets();

        // when
        List<List<Integer>> actual = findSubsets.findAllSubsets(input);

        // then
        assertIterableEquals(expected, actual);

    }

}
