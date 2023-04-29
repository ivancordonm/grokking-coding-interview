package mergeintervals.insertinterval;

import mergeintervals.mergeintervals.Interval;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import utils.IntervalConverter;
import utils.IntervalsConverter;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InsertIntervalTest {

    @CsvSource(value = {
            "1:2,3:4,5:6,7:8;6:10;1:2,3:4,5:10",
            "1:2,3:4,5:8,9:15;2:5;1:8,9:15",
            "1:6,8:9,10:15,16:18;9:10;1:6,8:15,16:18",
            "3:4;1:2;1:2,3:4"
    }, delimiter = ';')
    @ParameterizedTest(name = "merge({0}, {1}) = {2}")
    void insertInterval(@ConvertWith(IntervalsConverter.class) List<Interval> intervals,
                        @ConvertWith(IntervalConverter.class) Interval newInterval,
                        @ConvertWith(IntervalsConverter.class) List<Interval> expected) {

        assertEquals(expected, new InsertInterval().insertInterval(intervals, newInterval));

    }
}
