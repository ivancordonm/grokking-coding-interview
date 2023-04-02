package slidingwindow.repeateddnasequence

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import utils.setStringConverter

class RepeatedDNASequencesKtTest {

    @ParameterizedTest(name = "#{index} Test with String {0}")
    @CsvSource(
        value = ["AAAAACCCCCAAAAACCCCCC;8;AAAAACCC, AAAACCCC, AAACCCCC",
            "GGGGGGGGGGGGGGGGGGGGGGGGG;12;GGGGGGGGGGGG",
            "TTTTTCCCCCCCTTTTTTCCCCCCCTTTTTTT;10;TTTTTCCCCC, TTTTCCCCCC, TTTCCCCCCC, TTCCCCCCCT, TCCCCCCCTT, CCCCCCCTTT, CCCCCCTTTT, CCCCCTTTTT, CCCCTTTTTT"],
        delimiterString = ";"
    )
    fun getRepeatedSeq(input: String, k: Int, result: String) {
        assertEquals(result.setStringConverter(), getRepeatedSeq(input, k).toSet())
        assertEquals(result.setStringConverter(), getRepeatedSeq2(input, k).toSet())
    }
}
