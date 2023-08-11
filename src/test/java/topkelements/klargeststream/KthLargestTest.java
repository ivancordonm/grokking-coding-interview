package topkelements.klargeststream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KthLargestTest {

    static Stream<Arguments> getData() {
        return Stream.of(
            Arguments.of(new String[]{"KthLargest", "add", "add", "add", "add", "add"},
                new int[][]{{3}, {4, 5, 8, 2}, {3}, {5}, {10}, {9}, {4}},
                new Integer[]{null, 4, 5, 5, 8, 8})
        );
    }

    @MethodSource("getData")
    @ParameterizedTest(name = "run {index}: commands={0}, nums={1}, expected={2}")
    void should_return_the_kth_element(String[] commands, int[][] nums, Integer[] expected) {
        // Given
        KthLargest kthLargest = new KthLargest(nums[0][0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            // When
            var result = kthLargest.add(nums[i][0]);
            System.out.print(result + " ");
            // Then
            assertEquals(expected[i - 1], result);
        }
    }
}
