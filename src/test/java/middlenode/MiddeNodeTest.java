package middlenode;

import fastandslowpointers.middlenode.MiddeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.LinkedList;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MiddeNodeTest {

    static Stream<Arguments> listAndResultProvider() {
        return Stream.of(
                arguments(new Integer[]{1, 2, 3, 4, 5}, 3),
                arguments(new Integer[]{1, 2, 3, 4, 5, 6}, 4),
                arguments(new Integer[]{3, 2, 1}, 2),
                arguments(new Integer[]{10}, 10),
                arguments(new Integer[]{1, 2}, 2)
        );
    }

    @ParameterizedTest(name = "#{index} with list {0}")
    @MethodSource("listAndResultProvider")
    void getTheMiddle(Integer[] nodes, int result) {
        var middeNode = new MiddeNode();
        var linkedList = new LinkedList<Integer>();
        linkedList.createLinkedList(nodes);
        assertEquals(result, middeNode.getMiddleNode(linkedList.head));
    }

}
