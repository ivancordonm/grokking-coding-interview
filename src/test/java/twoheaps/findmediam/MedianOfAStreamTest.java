package twoheaps.findmediam;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedianOfAStreamTest {


    static Stream<Arguments> generateData() {
        return Stream.of(
            Arguments.arguments(
                new String[]{"MedianOfStream", "insertNum", "insertNum", "findMedian", "insertNum", "findMedian"},
                new Integer[]{null, 1, 2, null, 3, null},
                new Double[]{null, null, null, 1.5, null, 2.0}),
            Arguments.arguments(
                new String[]{"MedianOfStream", "insertNum", "findMedian", "insertNum", "insertNum", "findMedian", "insertNum", "findMedian"},
                new Integer[]{null, 22, null, 35, 36, null, 27, null},
                new Double[]{null, null, 22.0, null, null, 35.0, null, 31.0}),
            Arguments.arguments(
                new String[]{"MedianOfStream", "insertNum", "findMedian", "insertNum", "findMedian"},
                new Integer[]{null, 1, null, 1, null},
                new Double[]{null, null, 1.0, null, 1.0})
        );
    }


    @MethodSource("generateData")
    @ParameterizedTest(name = "run {index}: commands={0}, nums={1}, expected={2}")
    void should_calculate_median(String[] commands, Integer[] nums, Double[] expected) {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        for (int i = 0; i < commands.length; i++) {
            if (commands[i].equals("insertNum")) {
                medianOfAStream.insertNum(nums[i]);
            } else if (commands[i].equals("findMedian")) {
                double actual = medianOfAStream.findMedian();
                assertEquals(expected[i], actual);
            }
        }
    }

}
