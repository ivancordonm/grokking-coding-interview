package slidingwindow.minwindowsubsequence;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinWindowTest {

    @CsvSource(value = {"ababc,abc,abc",
            "abcdebdde,bde,bcde"})
    @ParameterizedTest(name = "Test {index}: input={0}, expected={1}")
    void getMinimumString(String str1, String str2, String expected) {
        var minWindow = new MinWindow();
        assertEquals(expected, minWindow.getMinimumString(str1, str2));
    }

}
