package topkelements.reorganizestrings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReorganizeTest {

    @CsvSource({
        "aab, aba",
        "aaab, ''",
        "aaaaabbbbbbb, ''",
        "jjjjj, ''",
        "fofjjb, fjofjb"
    })
    @ParameterizedTest(name = "should reorganize string {0} to {1}")
    void reorganizeString(String input, String expected) {
        // given
        Reorganize reorganize = new Reorganize();

        // when
        String actual = reorganize.reorganizeString(input);

        // then
        assertEquals(expected, actual);
    }
}
