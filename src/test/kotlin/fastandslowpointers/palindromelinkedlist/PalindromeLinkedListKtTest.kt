package fastandslowpointers.palindromelinkedlist

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import utilskotlin.LinkedList
import java.util.stream.Stream

class PalindromeLinkedListKtTest {

    companion object {

        @JvmStatic
        fun listAndResultProvider(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.arguments(arrayOf(1, 2, 3, 3, 2, 1), true),
                Arguments.arguments(arrayOf(4, 7, 9, 5, 4), false),
                Arguments.arguments(arrayOf(2, 3, 5, 5, 3, 2), true),
                Arguments.arguments(arrayOf(6, 1, 0, 5, 1, 6), false),
                Arguments.arguments(arrayOf(3, 6, 9, 8, 4, 8, 9, 6, 3), true),
                Arguments.arguments(arrayOf(0, 0, 0, 0, 0, 0, 0, 0), true),
                Arguments.arguments(arrayOf(1), true),
                Arguments.arguments(arrayOf(1, 1), true),
                Arguments.arguments(arrayOf(1, 2), false)
            )
        }

    }

    @ParameterizedTest(name = "#{index} Text with list {0}")
    @MethodSource("listAndResultProvider")
    fun isPalindrome(nodes: Array<Int>, result: Boolean) {
        val linkedList = LinkedList<Int>()
        linkedList.createLinkedList(nodes)
        assertEquals(result, isPalindromeLinkedList(linkedList.head!!))
    }
}
