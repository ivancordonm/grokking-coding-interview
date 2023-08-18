package topkelements.topkfrequent;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import utils.IntArrayConverter;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FrequentElementsTest {

    @CsvSource(value = {
        "1,1,1,2,2,3;2;1,2",
        "1;1;1",
        "3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6;10;1,2,3,4,5,6,7,8,10,11"
    }, delimiter = ';')
    @ParameterizedTest(name = "should return top {1} frequent elements from {0}")
    void topKFrequent(@ConvertWith(IntArrayConverter.class) int[] input, int k,
                      @ConvertWith(IntArrayConverter.class) int[] expected) {
        // given
        FrequentElements frequentElements = new FrequentElements();

        // when
        var result = frequentElements.topKFrequent(input, k);

        // then
        assertEquals(Arrays.stream(expected).boxed().collect(Collectors.toSet()), Set.copyOf(result));
    }

}
