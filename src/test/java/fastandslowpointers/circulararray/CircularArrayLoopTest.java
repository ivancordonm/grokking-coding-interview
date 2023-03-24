package fastandslowpointers.circulararray;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CircularArrayLoopTest {

    static Stream<Arguments> listAndResultProvider() {
        return Stream.of(
                arguments(new int[]{1, 2, 3, 4, 5}, true),
                arguments(new int[]{1, 3, -2, -4, 1}, true),
                arguments(new int[]{2, 1, -1, -2}, false),
                arguments(new int[]{3, 2, 1, 1, -4, 1}, false),
                arguments(new int[]{1, 2, -3, 3, 4, 7, 1}, true),
                arguments(new int[]{-1, -1, -1, -1, -1, -1}, true)
        );
    }

    @ParameterizedTest(name = "#{index} Test with list {0}")
    @MethodSource("listAndResultProvider")
    void isCircularArrayLoop(int[] nums, boolean result) {
        var circularArrayLoop = new CircularArrayLoop();
        assertEquals(result, circularArrayLoop.isCircularArrayLoop(nums));
    }

}
