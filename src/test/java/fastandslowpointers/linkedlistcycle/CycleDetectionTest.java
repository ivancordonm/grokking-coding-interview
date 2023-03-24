package fastandslowpointers.linkedlistcycle;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.LinkedList;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CycleDetectionTest {

    static Stream<Arguments> listAndResultProvider() {
        return Stream.of(
                arguments(new Integer[]{2, 4, 6, 8, 10}, true, 0),
                arguments(new Integer[]{1, 3, 5, 7, 9}, false, 1),
                arguments(new Integer[]{1, 2, 3, 4, 5}, true, 2),
                arguments(new Integer[]{0, 2, 3, 5, 6}, false, 3),
                arguments(new Integer[]{3, 6, 9, 10, 11}, true, 4),
                arguments(new Integer[]{2, 2, 4, 5, 6, 3, 2, 4}, false, 5));
    }

    @ParameterizedTest(name = "#{index} Test with list {0}")
    @MethodSource("listAndResultProvider")
    void detectCycle(Integer[] nodes, boolean result, int index) {
        var cycleDetector = new CycleDetection();
        var linkedList    = new LinkedList<Integer>();
        linkedList.createLinkedList(nodes);
        if (index % 2 == 0) linkedList.head.next.next.next.next.next = linkedList.head.next;
        assertEquals(result, cycleDetector.detectCycle(linkedList.head));
    }

}
