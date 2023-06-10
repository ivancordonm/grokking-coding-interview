package inplacereversallinkedlist.reoderlits;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.LinkedList;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class ReorderTest {

    static Stream<Arguments> listAndResultProvider() {
        return Stream.of(
            Arguments.of(new Integer[]{1, 2, 3, 4, 5}, new Integer[]{1, 5, 2, 4, 3}),
            Arguments.of(new Integer[]{1, 2, 3, 4, 5, 6}, new Integer[]{1, 6, 2, 5, 3, 4}),
            Arguments.of(new Integer[]{1, 2, 3, 4, 5, 6, 7}, new Integer[]{1, 7, 2, 6, 3, 5, 4}),
            Arguments.of(new Integer[]{1}, new Integer[]{1})
        );
    }

    @MethodSource("listAndResultProvider")
    @ParameterizedTest(name = "reorder({0}) should return {1}")
    void reorder(Integer[] nodes, Integer[] expected) {
        // given
        var list = new LinkedList<Integer>();
        list.createLinkedList(nodes);
        Reorder solution = new Reorder();

        var expectedList = new LinkedList<Integer>();
        expectedList.createLinkedList(expected);

        // when
        var result = solution.reorderList(list.head);

        // then
        assertIterableEquals(expectedList.head, result);
    }

}
