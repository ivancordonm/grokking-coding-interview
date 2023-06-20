package inplacereversallinkedlist.reversenodes;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.LinkedList;
import utils.LinkedListNode;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class ReverseNodesTest {

    static Stream<Arguments> testDataProvider() {
        return Stream.of(
            Arguments.of(new Integer[]{1, 2, 3, 4}, new Integer[]{1, 3, 2, 4}),
            Arguments.of(new Integer[]{1, 2, 3, 4, 5}, new Integer[]{1, 3, 2, 5, 4}),
            Arguments.of(new Integer[]{1, 2, 3, 4, 5, 6}, new Integer[]{1, 3, 2, 4, 5, 6}),
            Arguments.of(new Integer[]{1, 2, 3, 4, 5, 6, 7}, new Integer[]{1, 3, 2, 4, 5, 6, 7}),
            Arguments.of(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8}, new Integer[]{1, 3, 2, 4, 5, 6, 8, 7}),
            Arguments.of(new Integer[]{1, 2}, new Integer[]{1, 2}),
            Arguments.of(new Integer[]{1}, new Integer[]{1}),
            Arguments.of(new Integer[]{}, new Integer[]{})
        );
    }

    @MethodSource("testDataProvider")
    @ParameterizedTest
    void should_reverse_groups(Integer[] origin, Integer[] expected) {
        // Given
        ReverseNodes reverseNodes = new ReverseNodes();
        LinkedList<Integer> originList = new LinkedList<>();
        originList.createLinkedList(origin);
        LinkedList<Integer> expectedList = new LinkedList<>();
        expectedList.createLinkedList(expected);

        // When
        LinkedListNode<Integer> processedList = reverseNodes.reverseEvenLengthGroups(originList.head);

        // Then
        assertIterableEquals(expectedList.head, processedList);
    }

}
