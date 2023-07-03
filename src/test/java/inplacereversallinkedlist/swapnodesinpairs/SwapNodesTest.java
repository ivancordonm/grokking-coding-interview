package inplacereversallinkedlist.swapnodesinpairs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.LinkedList;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class SwapNodesTest {


    static Stream<Arguments> testDataProvider() {
        return Stream.of(
            Arguments.arguments(new Integer[]{1, 2, 3, 4}, new Integer[]{2, 1, 4, 3}),
            Arguments.arguments(new Integer[]{1, 2, 3, 4, 5}, new Integer[]{2, 1, 4, 3, 5}),
            Arguments.arguments(new Integer[]{1, 2, 3, 4, 5, 6}, new Integer[]{2, 1, 4, 3, 6, 5}),
            Arguments.arguments(new Integer[]{1}, new Integer[]{1}),
            Arguments.arguments(new Integer[]{}, new Integer[]{}));
    }


    @MethodSource("testDataProvider")
    @ParameterizedTest(name = "{index} => root = {0}, expected = {1}")
    void should_test_the_solution(Integer[] source, Integer[] expected) {
        var sourceList = new LinkedList<Integer>();
        sourceList.createLinkedList(source);
        var expectedList = new LinkedList<Integer>();
        expectedList.createLinkedList(expected);
        var actual = new SwapNodes().swapPairs(sourceList.head);
        assertIterableEquals(expectedList.head, actual);
    }
}
