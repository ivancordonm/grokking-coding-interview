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
                new Integer[]{null, 4, 5, 5, 8, 8}),
            Arguments.of(
                new String[]{"KthLargest", "add", "add", "add", "add", "add", "add", "add", "add", "add", "add"},
                new int[][]{{6}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {11}, {12}, {13}, {14}, {15}, {16}, {17}, {18}, {19}, {20}},
                new Integer[]{null, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}
            ),
            Arguments.of(
                new String[]{"KthLargest", "add", "add", "add", "add", "add", "add", "add", "add", "add", "add"},
                new int[][]{{8}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {-1}, {-2}, {-3}, {-4}, {-5}, {-6}, {-7}, {-8}, {-9}, {-10}},
                new Integer[]{null, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}
            )
        );
    }

    @MethodSource("getData")
    @ParameterizedTest(name = "run {index}: commands={0}, nums={1}, expected={2}")
    void should_return_the_kth_element(String[] commands, int[][] nums, Integer[] expected) {

        KthLargest kthLargest = null;

        for (int i = 0; i < commands.length; i++) {
            if (commands[i].equals("KthLargest")) {
                kthLargest = new KthLargest(nums[i][0], nums[i + 1]);
                i++;
            } else {
                assert kthLargest != null;
                var result = kthLargest.add(nums[i][0]);
                assertEquals(expected[i - 1], result);
            }
        }
    }
}
