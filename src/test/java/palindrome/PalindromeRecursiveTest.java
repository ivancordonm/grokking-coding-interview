package palindrome;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import twopointers.palindrome.PalindromeRecursive;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PalindromeRecursiveTest {

    @ParameterizedTest(name = "#{index} - Test with String : {0}")
    @CsvSource({"kayak,TRUE", "hello,FALSE", "RACEACAR,FALSE", "A,TRUE", "ABCDABCD,FALSE", "DCBAABCD,TRUE", "ABCBA,TRUE"})
    void given_a_string_when_chek_if_it_is_palindrome_then_should_return_correct_answer(String s, boolean result) {
        PalindromeRecursive palindromeRecursive = new PalindromeRecursive();
        assertEquals(result, palindromeRecursive.isPalindrome(s));
    }

}
