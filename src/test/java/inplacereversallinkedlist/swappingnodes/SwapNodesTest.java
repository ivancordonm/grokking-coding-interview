package inplacereversallinkedlist.swappingnodes;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.LinkedList;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class SwapNodesTest {

    static Stream<Arguments> testDataProvider() {
        return Stream.of(
            Arguments.of(new Integer[]{1, 2}, 3, new Integer[]{1, 2}),
            Arguments.of(new Integer[]{1, 2, 3, 4, 5}, 2, new Integer[]{1, 4, 3, 2, 5}),
            Arguments.of(new Integer[]{7, 9, 6, 6, 7, 8, 3, 0, 9, 5}, 5, new Integer[]{7, 9, 6, 6, 8, 7, 3, 0, 9, 5}),
            Arguments.of(new Integer[]{1}, 1, new Integer[]{1}),
            Arguments.of(new Integer[]{1, 2}, 1, new Integer[]{2, 1}),
            Arguments.of(new Integer[]{1, 2, 3}, 2, new Integer[]{1, 2, 3}),
            Arguments.of(new Integer[]{7, 9, 6, 6, 7, 8, 3, 0, 9, 5}, 8, new Integer[]{7, 9, 0, 6, 7, 8, 3, 6, 9, 5}),
            Arguments.of(new Integer[]{}, 1, new Integer[]{})
        );
    }

    @MethodSource("testDataProvider")
    @ParameterizedTest(name = "{index} => head = {0}, k = {1}, expected = {2}")
    void should_test_solution(Integer[] source, int k, Integer[] expected) {
        // given
        var swapNodes = new SwapNodes();
        var list = new LinkedList<Integer>();
        list.createLinkedList(source);
        var expectedList = new LinkedList<Integer>();
        expectedList.createLinkedList(expected);

        // when
        var result = swapNodes.swapNodes(list.head, k);

        // then
        assertIterableEquals(expectedList.head, result);
    }
}
