package kwaymerge.kpairssmallestsum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import utils.IntArrayConverter;
import utils.ListOfListOfIntConverter;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindKPairsTest {

    @CsvSource(value = {
        "1,2;3;4;1,3:2,3",
        "1,1,2;1;4;1,1:1,1:2,1",
        "1,2,300;1,11,20,35,300;30;1,1:2,1:1,11:2,11:1,20:2,20:1,35:2,35:1,300:300,1:2,300:300,11:300,20:300,35:300,300",
        "4,7,9;4,7,9;5;4,4:4,7:7,4:4,9:9,4",
        "1,2;3,4;3;1,3:2,3:1,4",
        "1,1,2;1,2,3;2;1,1:1,1",
        ";2;3;",
    }, delimiter = ';')
    @ParameterizedTest(name = "run #{index}: nums1={0}, nums2={1}, k={2}, expected={3}")
    void should_find_k_pairs_with_smallest_sum(@ConvertWith(IntArrayConverter.class) int[] nums1Str,
                                               @ConvertWith(IntArrayConverter.class) int[] nums2Str,
                                               int k,
                                               @ConvertWith(ListOfListOfIntConverter.class) List<List<Integer>> expected) {

        // given
        var findkPairs = new FindKPairs();

        // when
        var actual = findkPairs.kSmallestPairs(nums1Str, nums2Str, k);

        System.out.println("actual = " + actual);
        System.out.println("expected = " + expected);
        // then
        assertEquals(Set.copyOf(expected), Set.copyOf(actual));
    }

}
