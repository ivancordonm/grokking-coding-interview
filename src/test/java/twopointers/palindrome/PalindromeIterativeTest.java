package twopointers.palindrome;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PalindromeIterativeTest {

    @ParameterizedTest(name = "#{index} - Test with String : {0}")
    @CsvSource({"kayak,true", "hello,false", "RACEACAR,false", "A,true", "ABCDABCD,false", "DCBAABCD,true", "ABCBA,true"})
    void given_a_string_when_chek_if_it_is_palindrome_then_should_return_correct_answer(String s, boolean result) {
        PalindromeIterative palindromeIterative = new PalindromeIterative();
        assertEquals(result, palindromeIterative.isPalindrome(s));
    }

}
