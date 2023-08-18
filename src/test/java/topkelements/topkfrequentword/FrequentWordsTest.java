package topkelements.topkfrequentword;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import utils.ArrayOfStringConverter;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class FrequentWordsTest {

    @CsvSource(value = {
        "aaa,aaa,bbb,bbb,ccc;2;aaa,bbb",
        "lets,play,cricket,and,then,lets,play,badminton;3;lets,play,and",
        "for,every,action,there,is,an,equal,but,opposite,reaction;2;action,an"
    }, delimiter = ';')
    @ParameterizedTest(name = "should return {2} most {1} frequent words from {0}")
    void shouldReturnKMostFrequentWords(@ConvertWith(ArrayOfStringConverter.class) String[] input, int k,
                                        @ConvertWith(ArrayOfStringConverter.class) String[] expected) {
        // given
        FrequentWords frequentWords = new FrequentWords();

        // when
        var actual = frequentWords.topKFrequent(input, k);

        // then
        assertIterableEquals(List.of(expected), actual);
    }
}
