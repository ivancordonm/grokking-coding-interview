package fastandslowpointers.palindromelinkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.LinkedList;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LinkedLinkPalindromeTest {

    static Stream<Arguments> listAndResultProvider() {
        return Stream.of(
                arguments(new Integer[]{1, 2, 3, 3, 2, 1}, true),
                arguments(new Integer[]{4, 7, 9, 5, 4}, false),
                arguments(new Integer[]{2, 3, 5, 5, 3, 2}, true),
                arguments(new Integer[]{6, 1, 0, 5, 1, 6}, false),
                arguments(new Integer[]{3, 6, 9, 8, 4, 8, 9, 6, 3}, true),
                arguments(new Integer[]{0, 0, 0, 0, 0, 0, 0, 0}, true),
                arguments(new Integer[]{1}, true),
                arguments(new Integer[]{1, 1}, true),
                arguments(new Integer[]{1, 2}, false)
                );
    }

    @ParameterizedTest(name = "#{index} Text with list {0}")
    @MethodSource("listAndResultProvider")
    void isPalindrome(Integer[] nodes, boolean result) {
        var linkedList = new LinkedList<Integer>();
        linkedList.createLinkedList(nodes);
        var palindrome = new LinkedListPalindrome();
        assertEquals(result, palindrome.isPalindrome(linkedList.head));
    }
}
