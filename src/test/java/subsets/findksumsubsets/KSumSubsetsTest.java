package subsets.findksumsubsets;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import utils.ListIntConverter;
import utils.ListOfListOfIntConverter;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KSumSubsetsTest {

    @CsvSource(value = {
        "8,13,3,22,17,39,87,45,36;3;3",
        "8,13,3,22,17,39,87,45,36;47;8,3,36,8,22,17,8,39"
    }, delimiter = ';')
    @ParameterizedTest(name = "getKSumSubsets({0}, {1}) = {2}")
    void getKSumSubsets(@ConvertWith(ListIntConverter.class) List<Integer> input, int targetSum, @ConvertWith(ListOfListOfIntConverter.class)List<List<Integer>expected) {
        // given
        var ksumSubsets = new KsumSubsets();

        // when
        var actual = ksumSubsets.getKSumSubsets(input, targetSum);

        // then
        assertEquals(expected, actual);
    }

}
