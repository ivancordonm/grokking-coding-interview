package mergeintervals.Intervallistintersections;

import mergeintervals.mergeintervals.Interval;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import utils.IntervalsConverter;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntersectionTest {

    @CsvSource(value = {
            "2:6,7:9,10:13,14:19,20:24;1:4,6:8,15:18;2:4,6:6,7:8,15:18",
            "1:4,5:6,7:8,9:15;2:4,5:7,9:15;2:4,5:6,7:7,9:15",
            "1:2;1:2;1:2"
    }, delimiter = ';')
    @ParameterizedTest(name = "Intervals {0} and {1} should intersect to {2}")
    void intervalsIntersection(@ConvertWith(IntervalsConverter.class) List<Interval> first,
                               @ConvertWith(IntervalsConverter.class) List<Interval> second,
                               @ConvertWith(IntervalsConverter.class) List<Interval> expected) {
        assertEquals(expected, new Intersection().intervalsIntersection(first, second));
    }
}
