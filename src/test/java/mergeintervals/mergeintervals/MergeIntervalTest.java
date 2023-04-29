package mergeintervals.mergeintervals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import utils.IntervalsConverter;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MergeIntervalTest {

    @CsvSource(value = {
            "1:5,3:7,4:6;1:7",
            "1:5,4:6,6:8,11:15;1:8,11:15"
    }, delimiterString = ";")
    @ParameterizedTest(name = "mergeIntervals({0}) = {1}")
    void mergeIntervals(@ConvertWith(IntervalsConverter.class) List<Interval> intervals,
                        @ConvertWith(IntervalsConverter.class) List<Interval> expected) {
        assertEquals(expected, new MergeInterval().mergeIntervals(intervals));
    }
}
