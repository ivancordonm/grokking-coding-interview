package twopointers.reversestring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ReverseStringTest {

    @ParameterizedTest(name = "#{index} Test with String: {0}")
    @CsvSource({"We love Python,Python love We","To be or not to be,be to not or be To","You are amazing,amazing are You",
            "Hello     World,World Hello","Hey,Hey"})
    void reverseString(String s, String result) {
        ReverseString reverseString = new ReverseString();
        var r = reverseString.reverse(s);
        assertEquals(result, r);
        System.out.println(s + " - " + r);
    }

    @Test
    void reverseStringWithSpaces() {
        ReverseString reverseString = new ReverseString();
        var r = reverseString.reverse("   trim   spaces   ");
        assertEquals("spaces trim", r);
    }

}
