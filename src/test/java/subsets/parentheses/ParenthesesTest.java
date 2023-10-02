package subsets.parentheses;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import utils.StringListConverter;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParenthesesTest {

    @CsvSource(value = {
        "0;",
        "1;()",
        "2;()(),(())",
        "3;((())),(()()),(())(),()(()),()()()",
        "4;(((()))),((()())),((())()),((()))(),(()(())),(()()()),(()())(),(())(()),(())()(),()((())),()(()()),()(())(),()()(()),()()()()"
    }, delimiter = ';')
    @ParameterizedTest(name = "generateParentheses({0}) = {1}")
    void generateParentheses(int n, @ConvertWith(StringListConverter.class) List<String> expected) {
        // given
        var parentheses = new Parentheses();

        // when
        var actual = parentheses.generateValidParentheses(n);

        // then all elements in expected should be in actual
        assertEquals(expected.size(), actual.size());
        for (var e : expected) {
            assertEquals(1, actual.stream().filter(a -> a.equals(e)).count());
        }

    }
}
