package inplacereversallinkedlist.reverselinkedlist2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.LinkedList;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ReverseLinkedList2Test {

    static Stream<Arguments> listAndResultProvider() {
        return Stream.of(
                arguments(new Integer[] { 1, 2, 3, 4, 5, 6, 7 }, 2, 5, new Integer[] { 1, 5, 4, 3, 2, 6, 7 }),
                arguments(new Integer[] { 1, 2, 3, 4, 5, 4, 3, 2, 8 }, 1, 9,
                        new Integer[] { 8, 2, 3, 4, 5, 4, 3, 2, 1 }),
                arguments(new Integer[] { -10, -20, -30, -40, -50, -60, -70, -80, -90 }, 1, 8,
                        new Integer[] { -80, -70, -60, -50, -40, -30, -20, -10, -90 }),
                arguments(new Integer[] { 1, 2, 3, 4, 5 }, 1, 5, new Integer[] { 5, 4, 3, 2, 1 }),
                arguments(new Integer[] { 1, 2, 3, 4, 5 }, 2, 4, new Integer[] { 1, 4, 3, 2, 5 }),
                arguments(new Integer[] { 1, 2, 3, 4, 5 }, 1, 1, new Integer[] { 1, 2, 3, 4, 5 }),
                arguments(new Integer[] { 1, 2, 3, 4, 5 }, 5, 5, new Integer[] { 1, 2, 3, 4, 5 }));
    }

    @MethodSource("listAndResultProvider")
    @ParameterizedTest(name = "reverseBetween({0}, {1}, {2}) should return {3}")
    void testReverseBetween(Integer[] nodes, int m, int n, Integer[] nodesResult) {
        var list = new LinkedList<Integer>();
        list.createLinkedList(nodes);
        var result = new LinkedList<Integer>();
        result.createLinkedList(nodesResult);
        assertIterableEquals(result.head, new ReverseLinkedList2().reverseBetween(list.head, m, n));
    }
}
