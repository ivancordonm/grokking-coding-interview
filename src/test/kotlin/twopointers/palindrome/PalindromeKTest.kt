package twopointers.palindrome

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals

class PalindromeKTest {

    @ParameterizedTest(name = "#{index} - Test with String : {0}")
    @CsvSource("kayak,true", "hello,false", "RACEACAR,false", "A,true", "ABCDABCD,false", "DCBAABCD,true", "ABCBA,true")
    fun given_a_string_when_chek_if_it_is_a_palindrome_then_should_return_correct_answer(s: String, result: Boolean) {
        assertEquals(result, isPalindromeIterative(s))
        assertEquals(result, isPalindromeRecursive(s))
    }

}
