package slidingwindow.repeateddnasequence;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import utils.StringSetConverter;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RepeatedDNASequencesTest {

    @ParameterizedTest(name = "#{index} Test with String {0}")
    @CsvSource(
            value = {"AAAAACCCCCAAAAACCCCCC;8;AAAAACCC, AAAACCCC, AAACCCCC",
                    "GGGGGGGGGGGGGGGGGGGGGGGGG;12;GGGGGGGGGGGG",
                    "TTTTTCCCCCCCTTTTTTCCCCCCCTTTTTTT;10;TTTTTCCCCC, TTTTCCCCCC, TTTCCCCCCC, TTCCCCCCCT, TCCCCCCCTT, CCCCCCCTTT, CCCCCCTTTT, CCCCCTTTTT, CCCCTTTTTT"},
            delimiterString = ";"
    )
    void getSequences(String input, int k, @ConvertWith(StringSetConverter.class) Set<String> result) {
        RepeatedDNASequences repeatedDNASequences = new RepeatedDNASequences();
        assertEquals(result, Set.copyOf(repeatedDNASequences.getSequences(input, k)));
    }
}
