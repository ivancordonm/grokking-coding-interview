package inplacereversallinkedlist.reverselinkgroup;


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
            arguments(new Integer[]{1,2,3,4,5,6,7}, 2, new Integer[]{2,1,4,3,6,5,7}),
            arguments(new Integer[]{3,4,5,6,2,8,7,7}, 3, new Integer[]{5,4,3,8,2,6,7,7}),
            arguments(new Integer[]{3,4}, 30, new Integer[]{3,4}),
            arguments(new Integer[]{}, 3, new Integer[]{})
        );
    }

    @ParameterizedTest(name = "reverse {0} by {1} group(s)")
    @MethodSource("listAndResultProvider")
    void reverse(Integer[] nodes, int k, Integer[] nodesReversed) {
        var list = new LinkedList<Integer>();
        list.createLinkedList(nodes);
        var result = new LinkedList<Integer>();
        result.createLinkedList(nodesReversed);
        assertIterableEquals(result.head, new ReverseLinkedList().reverse(list.head, k));
    }
}
