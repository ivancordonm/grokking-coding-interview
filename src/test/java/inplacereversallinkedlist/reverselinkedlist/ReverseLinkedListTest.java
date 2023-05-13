package inplacereversallinkedlist.reverselinkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.LinkedList;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ReverseLinkedListTest {

    static Stream<Arguments> listAndResultProvider() {
        return Stream.of(
            arguments(new Integer[]{1, -2, 3, 4, -5, 4, 3, -2, 1}, new Integer[]{1, -2, 3, 4, -5, 4, 3, -2, 1}),
            arguments(new Integer[]{-1, 2, -3, 4}, new Integer[]{4, -3, 2, -1})
        );
    }

    @ParameterizedTest(name = "reverseList() should return {1} when head = {0}")
    @MethodSource("listAndResultProvider")
    void reverse(Integer[] nodes, Integer[] nodesReversed) {
        var list = new LinkedList<Integer>();
        list.createLinkedList(nodes);
        var listReversed = new LinkedList<Integer>();
        listReversed.createLinkedList(nodesReversed);
        assertIterableEquals(listReversed.head, new ReverseLinkedList().reverse(list.head));
    }
}
