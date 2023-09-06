package modifiedbinarysearch.findkclosestelements;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import utils.IntArrayConverter;
import utils.ListIntConverter;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class KClosestTest {

    @CsvSource(value = {
        "1,2,3,4,5;4;3;1,2,3,4",
        "1,2,3,4,5;4;-1;1,2,3,4",
        "1,2,3,4,5,6,7;5;7;3,4,5,6,7",
        "-29,-11,-3,0,5,10,50,63,198;6;8;-29,-11,-3,0,5,10",
        "-10,-6,-4,-3;2;5;-4,-3"
    }, delimiter = ';')
    @ParameterizedTest(name = "run #{index} with [{arguments}]")
    void findClosestElements(@ConvertWith(IntArrayConverter.class) int[] input, int k, int x,
                             @ConvertWith(ListIntConverter.class) List<Integer> expected) {

        // when
        var kClosest = new KClosest();

        // then
        var actual = kClosest.findClosestElements(input, k, x);

        // assert
        assertIterableEquals(expected, actual);
    }
}
