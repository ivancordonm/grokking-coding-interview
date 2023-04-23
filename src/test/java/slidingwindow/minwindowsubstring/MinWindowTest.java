package slidingwindow.minwindowsubstring;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinWindowTest {
    @CsvSource(value = {
            "cabwefgewcwaefgcf,cae,cwae",
            "ABCD,ABC,ABC",
            "XYZYX,XYZ,XYZ",
            "AAAAAAAAAAA,A,A"})
    @ParameterizedTest(name = "Test {index}: s = {0}, t = {1}, expected = {2}")
    void minWindow(String s, String t, String expected) {
        MinWindow minWindow = new MinWindow();
        assertEquals(expected, minWindow.minWindow(s, t));
    }
}
