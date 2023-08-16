package topkelements.kclosestpoints;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import utils.Point;
import utils.PointsToArrayConverter;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClosestPointsTest {

    @CsvSource(value = {
        "-1:-3,-4:-5,-2:-2,-2:-3;3;-1:-3,-2:-2,-2:-3",
        "1:-3,4:-2,2:-1,-2:2,-5:3,3:-2;4;3:-2,1:-3,2:-1,-2:2"
    }, delimiter = ';')
    @ParameterizedTest(name = "should return {2} when points are {0} and k is {1}")
    void findClosestPoints(@ConvertWith(PointsToArrayConverter.class) Point[] points, int k,
                           @ConvertWith(PointsToArrayConverter.class) Point[] expected) {
        // given
        var sut = new ClosestPoints();

        // when
        var actual = sut.kClosest(points, k);

        // then
        assertEquals(Set.copyOf(actual), Set.of(expected));
    }
}
